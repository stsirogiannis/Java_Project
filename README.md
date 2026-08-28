# Sports Academy Management System

A JavaFX desktop application for managing a sports academy: athletes, coaches,
training programs, subscriptions, reservations, and payments.

**Note:** The user-facing interface (menus, prompts, and messages) is in Greek.

## Features

- **Athlete management** — register, update, delete athletes; track professional
  status and experience level.
- **Enrollment payments** — pay an athlete's one-time enrollment fee, priced
  differently for amateurs and professionals.
- **Subscription management** — create sport/facility/coach/training-program
  records and subscribe an athlete to a training program, with automatic
  discount calculation.
- **Reservation management** — book and cancel an athlete's attendance in a
  specific training program on a given date.
- **Table-based UI** — every management screen lists existing records in a
  `TableView` alongside an input form.

## Tech Stack

- Java (JPMS module, `module-info.java`)
- JavaFX (Controls, Scene Graph)
- Maven

## Project Structure

The code is split into two packages:

- `gr.unipi.core` — plain domain/model classes (`User`, `Athlete`, `Coach`,
  `Sport`, `Facility`, `TrainingProgram`, `TrainingProgramReservation`,
  `Enrollment`, `Subscription`, `Payment`, `Pricelist`).
- `gr.unipi.gui` — JavaFX scenes and event handling (`App`, `SceneCreator`
  and its subclasses, `SystemInfo`).

See [Documentation.md](Documentation.md) for a full class-by-class breakdown,
business rules, and known limitations.

## Getting Started

### Prerequisites

- JDK 17+ (or the version configured in `pom.xml`)
- Maven 3.8+
- A JavaFX SDK compatible with your JDK (if not resolved automatically via
  Maven dependencies)

### Build

```bash
mvn clean install
```

### Run

If your `pom.xml` uses the `javafx-maven-plugin`:

```bash
mvn javafx:run
```

Otherwise, run the main class directly (adjust module path as needed):

```bash
mvn clean compile exec:java -Dexec.mainClass="gr.unipi.gui.App"
```

The application entry point is `gr.unipi.gui.App`.

## Usage

On launch you'll see a main menu with three options:

1. **Διαχείριση Αθλητών** (Athlete Management) — register athletes and pay
   their enrollment fee.
2. **Διαχείριση Συνδρομών** (Subscription Management) — set up sports,
   facilities, coaches, training programs, and subscribe an athlete.
3. **Διαχείριση Κρατήσεων** (Reservation Management) — reserve or cancel an
   athlete's spot in a training program.
