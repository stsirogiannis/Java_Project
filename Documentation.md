# Technical Documentation

## 1. Overview

This project is a JavaFX desktop application that models a sports academy's
core operations: athlete registration, enrollment payments, subscriptions to
training programs, and reservations. It follows a two-package structure that
separates the domain model from the UI:

- **`gr.unipi.core`** — plain Java objects representing the domain
  (people, programs, money).
- **`gr.unipi.gui`** — JavaFX `Scene`-building classes that own the UI
  controls, in-memory data lists, and event handling.

There is no persistence layer; all data (`athleteList`, `subscriptionList`,
`trainingProgramList`, `reservationList`, etc.) is held in `static`/instance
`ArrayList`s for the lifetime of the running application.

## 2. Package `gr.unipi.core` — Domain Model

### `User` (abstract)

Base class for people in the system: `userCount`, `name`, `surname`,
`gender`, `birthDate`, `contactInfo`, with standard getters/setters.

### `Athlete extends User`

Adds `isProfessional` and `experience`.

- **Business rule:** `experience` is only accepted if it is between 1 and 5
  inclusive; otherwise the setter silently leaves the previous value in
  place (it does not throw).

### `Coach extends User`

Adds `sport` (a `Sport` reference) and `degrees` (qualifications count).

- **Business rule:** `degrees` must be positive, or it is silently ignored.

### `Sport`

`sportName` and `professionalAccess` (whether the sport requires
professional-athlete access).

### `Facility`

`facilityName` and `maxCapacity`.

- **Business rule:** `maxCapacity` must be positive, or it is silently
  ignored.

### `TrainingProgram`

Aggregates `sport`, `facility`, `coach`, `minExperience`,
`weeklyReservation`, `gender` (target participant gender), `minDuration`,
and a JavaFX `dayComboBox`. Includes a descriptive `toString()`.

- **Business rule:** `minDuration` must be positive, or it is silently
  ignored.

### `TrainingProgramReservation`

Links an `athlete` to a `trainingProgram` on a given `date`, identified by
`TPRCode`. Exposes convenience getters `getUserCount()` and `getTPCount()`.

### `Pricelist` (interface)

Shared pricing constants implemented by `Enrollment`, `Subscription`, and
`Payment`:

| Constant                      | Value | Meaning                                        |
| ----------------------------- | ----- | ---------------------------------------------- |
| `amateurEnrollmentPrice`      | 50    | Enrollment fee for non-professional athletes   |
| `professionalEnrollmentPrice` | 20    | Enrollment fee for professional athletes       |
| `discountRate12`              | 0.1   | Subscription discount for 1–2 years experience |
| `discountRate34`              | 0.2   | Subscription discount for 3–4 years experience |
| `discountRate5`               | 0.3   | Subscription discount for 5 years experience   |
| `discountRateProf`            | 0.2   | Reserved for professional-related discounting  |

Each implementer defines `calculateTotalPrice()`.

### `Enrollment implements Pricelist`

One-time enrollment record for an athlete: `enrollmentDate`, `enrollCost`,
`discount`. `calculateTotalPrice()` returns `enrollCost`.

### `Subscription implements Pricelist`

A subscription record: `subCode`, `athlete`, `trainingProgram`,
`monthlyCost`. `calculateTotalPrice()` returns `monthlyCost`.

### `Payment implements Pricelist`

A payment record tying together `payCode`, `payDate`, `paymentMethod`, an
optional `subscription`, an optional `enrollment`, and `totalCost`.

## 3. Package `gr.unipi.gui` — Presentation Layer

### `App`

JavaFX `Application` entry point. Builds the four scenes (`mainScene`,
`athleteScene`, `subscriptionScene`, `reservationScene`) via their
`SceneCreator` subclasses and shows the main menu on start.

### `SceneCreator` (abstract)

Base class holding `width`/`height` and the abstract `createScene()` method
implemented by every screen.

### `MainSceneCreator`

Renders the main menu with three navigation buttons that switch
`App.primaryStage`'s scene.

### `AthleteManagementSceneCreator`

Owns `athleteList`, `paymentList`, `enrollmentList`. Responsibilities:

- Create/update/delete `Athlete` records (with experience validated 1–5).
- Open a modal payment window (`showEnrollmentPayWindow`) that calculates
  the enrollment fee (20 for professionals, 50 for amateurs), creates an
  `Enrollment` and a `Payment`, and displays the generated payment code.
- Keep `athleteTableView` / `enrollmentTableView` synced with the lists.

### `SubscriptionManagementSceneCreator`

Owns `sportList`, `facilityList`, `coachList`, `trainingProgramList`,
`subscriptionList`, `paymentList`. On **"Πληρωμή Συνδρομής"**:

1. Validates the entered athlete code against `athleteList`.
2. Creates a `Sport`, `Facility`, and `Coach` from the form fields.
3. Creates a `TrainingProgram` from those plus min-experience, weekly
   reservation flag, gender, and duration.
4. Verifies the athlete has a prior `Enrollment`.
5. Computes the monthly cost:
   - Experience-based discount: 10% (1–2 yrs), 20% (3–4 yrs), 30% (5 yrs).
   - An additional 20% off the _discounted_ amount if the athlete is **not**
     professional.
6. Creates the `Payment` and the `Subscription`, and syncs the table.

### `ReservationManagementSceneCreator`

Owns `reservationList`; reads `athleteList`, `subscriptionList`,
`trainingProgramList` from the other screens. Validates the athlete code,
training-program code, and an `yyyyMMdd` date before creating a
`TrainingProgramReservation`. Supports cancelling a reservation by code.

### `SystemInfo`

Small utility exposing the running `java.version` and `javafx.version`.

## 4. Data Flow Summary

Athlete registration ─▶ Enrollment (paid) ─▶ Subscription (requires enrollment)─▶TrainingProgramReservation (requires subscription-linked athlete + program)

All lists are shared across screens as `static` fields (e.g.
`AthleteManagementSceneCreator.athleteList` is read by both the subscription
and reservation screens), simulating a shared in-memory data store.

## 5. Possible Future Improvements

- Extract a data-access/service layer instead of manipulating `ArrayList`s
  directly inside GUI event handlers.
- Add persistence (e.g., a lightweight embedded database or serialization).
- Add unit tests for discount and pricing calculations.
