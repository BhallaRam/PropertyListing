# EstatePro — Property Listing App Prototype

A clean, modern, production-grade Android prototype for a **Property Listing & Management Application** featuring two distinct user roles: **User (Buyer)** and **Property Owner**. Built strictly following **Clean Architecture**, **MVVM**, **Jetpack Compose**, **Material 3**, **Room Database**, **Hilt Dependency Injection**, and **Kotlin Coroutines & StateFlow**.

---

## 📱 Features & Role Flows

### 1. Buyer / User Flow
- **Role Selection & Login**: Authenticate locally using dummy user credentials. On fresh app launch, the app always opens to the Login screen.
- **Discover Listings**: Browse a responsive catalog of realistic property listings across premier Indian cities (Jaipur, Jodhpur, Delhi, Gurgaon, Mumbai, Pune, Bangalore, Ahmedabad).
- **Multi-Criteria Search & Filtering**:
  - Real-time search across property names, locations, and descriptions.
  - Filter bottom sheet supporting City, Property Type (`APARTMENT`, `VILLA`, `ROW_HOUSE`), Price Range slider, Area Range, Status (`AVAILABLE`, `SOLD`, `RENTED`), and Configuration (1 BHK to 5 BHK).
  - Quick-filter chips with badge indicators for active filter counts.
- **Property Details**: View detailed specifications, carpet area, configuration, status badge, high-res photo gallery, and owner contact card.
- **Submit Interest (Local Room Persistence)**:
  - Interactive form capturing Buyer Name, 10-digit Mobile Number, Validated Email, and Remarks.
  - Comprehensive field-level input validation.
  - Duplicate submission prevention with interactive loading feedback.
  - Direct persistence into Room database.

### 2. Property Owner Flow
- **Owner Authentication**: Authenticate as a property owner (e.g. `owner@test.com`).
- **Owner Dashboard & Portal**:
  - **My Listings Tab**: View all properties owned by this owner, with status tags, inquiry counters, inline **Edit**, and **Delete** actions.
  - **Received Inquiries Tab**: View all buyer interest submissions received specifically for the owner's properties.
- **Add Property (Floating Action Button)**:
  - Floating Action Button on the Owner Dashboard navigates to the **Add Property** screen.
  - Form capturing: Property Name, Property Type (`APARTMENT`, `VILLA`, `ROW_HOUSE`), City/Location, Price (INR), Carpet Area (sq.ft), Configuration (1 BHK to 5 BHK), Listing Status (`AVAILABLE`, `SOLD`, `RENTED`), Description, and Image Preset/URL.
  - Automatically binds `ownerId` and `ownerName` from the authenticated owner.
- **Edit & Delete Property**:
  - **Edit**: Pre-populates the form with existing details, updates the Room record on save.
  - **Delete**: Prompts a safety confirmation dialog before permanently deleting the property from Room.
- **Role-Aware Property Details**:
  - The "Express Interest" action button is automatically hidden when viewing properties in Owner mode.
- **Strict Owner-Specific Inquiry Isolation**:
  - Inquiries are queried from Room filtered strictly by `WHERE ownerId = :ownerId`.
  - Inquiries submitted by buyers for `owner_01`'s properties will **never** be visible to `owner_02`.

---

## 🛠️ Technology Stack

| Layer / Concern | Technology |
|---|---|
| **Package Name & App ID** | `com.assessment.propertylisting` |
| **Language** | Kotlin 2.1.0 |
| **UI Framework** | Jetpack Compose (BOM 2024.12.01) |
| **Design System** | Material 3 (Custom Indigo/Sapphire & Warm Gold Palette) |
| **Architecture** | MVVM + Clean Architecture + Unidirectional Data Flow (UDF) |
| **Local Database** | Room Database 2.6.1 (SQLite) with KSP |
| **Dependency Injection** | Dagger Hilt 2.51.1 |
| **Asynchronous & State** | Kotlin Coroutines & `StateFlow` / `Flow` |
| **Navigation** | Navigation Compose 2.8.5 with backstack-safe transitions |
| **Image Loading** | Coil Compose 2.7.0 with vector fallbacks |
| **Build System** | Gradle 8.12 with Kotlin DSL (`build.gradle.kts`) |
| **Unit Testing** | JUnit 4 + `kotlinx-coroutines-test` |

---

## 🏛️ Architecture & Clean Design

The application enforces strict separation of concerns across three architectural layers:

```
Presentation Layer (Compose Screens, M3 Components, ViewModels with StateFlow)
                                      ↓
Domain Layer (Pure Kotlin Use Cases, Domain Models, Repository Interfaces)
                                      ↓
Data Layer (Repository Implementations, Room DAOs, Entities, Mappers, Seeder)
```

---

## 🔐 Dummy Login Credentials

| Role | Email | Password | Associated Owner / Name |
|---|---|---|---|
| **Buyer / User** | `user@test.com` | `user123` | Amit Verma |
| **Property Owner 1** | `owner@test.com` | `owner123` | Rajesh Sharma (`owner_01`) |
| **Property Owner 2** | `owner2@test.com` | `owner123` | Pooja Malhotra (`owner_02`) |

> [!TIP]
> The login screen contains a **"Reset Demo Credentials"** button and quick role toggle tabs for 1-tap testing convenience.

---

## 📂 Project Package Structure

```
com.assessment.propertylisting
├── PropertyListingApp.kt               # Application class (@HiltAndroidApp)
├── MainActivity.kt                     # Activity hosting Compose Navigation
│
├── data
│   ├── local
│   │   ├── AppDatabase.kt              # Room Database definition & seeder hook
│   │   ├── dao
│   │   │   ├── PropertyDao.kt          # CRUD Flow queries for properties
│   │   │   └── InterestDao.kt          # Inquiry queries and persistence
│   │   ├── entity
│   │   │   ├── PropertyEntity.kt       # Table: properties
│   │   │   └── InterestEntity.kt       # Table: interests
│   │   └── seed
│   │       └── DatabaseSeeder.kt       # 14 realistic dummy properties
│   ├── mapper
│   │   └── EntityMappers.kt            # Entity <-> Domain mappers
│   └── repository
│       ├── PropertyRepositoryImpl.kt   # PropertyRepository implementation
│       ├── InterestRepositoryImpl.kt   # InterestRepository implementation
│       └── AuthRepositoryImpl.kt       # Local dummy authentication
│
├── domain
│   ├── model
│   │   ├── Property.kt                 # Clean domain Property entity
│   │   ├── PropertyType.kt             # APARTMENT, VILLA, ROW_HOUSE
│   │   ├── PropertyStatus.kt           # AVAILABLE, SOLD, RENTED
│   │   ├── PropertyFilter.kt           # Filter state & active counter
│   │   ├── Interest.kt                 # Inbound interest domain model
│   │   ├── User.kt                     # Authenticated user model
│   │   └── UserRole.kt                 # USER, PROPERTY_OWNER
│   ├── repository
│   │   ├── PropertyRepository.kt       # Property repository interface
│   │   ├── InterestRepository.kt       # Interest repository interface
│   │   └── AuthRepository.kt           # Auth repository interface
│   └── usecase
│       ├── LoginUseCase.kt             # Validates credentials & returns user
│       ├── GetPropertiesUseCase.kt     # Retrieves all properties
│       ├── GetPropertyByIdUseCase.kt   # Retrieves single property by ID
│       ├── FilterPropertiesUseCase.kt  # Pure Kotlin multi-criteria filter engine
│       ├── SubmitInterestUseCase.kt    # Validates input & saves buyer inquiry
│       ├── GetOwnerPropertiesUseCase.kt# Retrieves listings by ownerId
│       ├── GetOwnerInterestsUseCase.kt # Retrieves interests strictly for ownerId
│       ├── AddPropertyUseCase.kt       # Validates and persists new property
│       ├── UpdatePropertyUseCase.kt    # Validates and updates existing property
│       └── DeletePropertyUseCase.kt    # Deletes property by ID
│
├── presentation
│   ├── navigation
│   │   ├── AppNavigation.kt            # NavHost graph definition
│   │   └── Routes.kt                   # Sealed navigation routes & argument keys
│   ├── theme
│   │   ├── Color.kt                    # Curated Material 3 color system
│   │   ├── Theme.kt                    # Material 3 Theme setup
│   │   ├── Type.kt                     # Typography hierarchy
│   │   └── Shape.kt                    # Custom rounded shapes
│   ├── components
│   │   ├── AppTopBar.kt                # Top bar with role badge & logout
│   │   ├── PropertyCard.kt             # Property card with image & badge overlay
│   │   ├── SearchBarComponent.kt       # Search bar with filter trigger badge
│   │   ├── FilterBottomSheet.kt        # Multi-attribute modal filter sheet
│   │   ├── StatusBadge.kt              # Available / Sold / Rented chip
│   │   ├── TypeBadge.kt                # Apartment / Villa / Row House chip
│   │   ├── EmptyState.kt               # Reusable empty result placeholder
│   │   ├── LoadingState.kt             # Loading shimmer / progress view
│   │   └── ErrorState.kt               # Error state with retry action
│   ├── login
│   │   ├── LoginScreen.kt              # Login UI with role selector
│   │   ├── LoginViewModel.kt           # Authentication ViewModel
│   │   └── LoginUiState.kt             # Login state model
│   ├── user
│   │   ├── dashboard
│   │   │   ├── UserDashboardScreen.kt  # Property list with search & filters
│   │   │   ├── UserDashboardViewModel.kt
│   │   │   └── UserDashboardUiState.kt
│   │   ├── propertydetail
│   │   │   ├── PropertyDetailScreen.kt # Property details (role-aware CTA)
│   │   │   ├── PropertyDetailViewModel.kt
│   │   │   └── PropertyDetailUiState.kt
│   │   └── interest
│   │       ├── InterestFormScreen.kt   # Inquiry submission form with validation
│   │       ├── InterestViewModel.kt
│   │       └── InterestUiState.kt
│   └── owner
│       ├── dashboard
│       │   ├── OwnerDashboardScreen.kt # Tabbed owner portal with FAB, Edit & Delete
│       │   ├── OwnerDashboardViewModel.kt
│       │   └── OwnerDashboardUiState.kt
│       └── addedit
│           ├── AddEditPropertyScreen.kt# Full property publication/edit form
│           ├── AddEditPropertyViewModel.kt
│           └── AddEditPropertyUiState.kt
│
└── di
    ├── DatabaseModule.kt               # Hilt provider for Room DB & DAOs
    └── RepositoryModule.kt             # Hilt binding for repositories
```

---

## 🧪 Testing & Verification

Comprehensive unit test suites have been implemented and verified:

```bash
./gradlew test
```

### Test Coverage Highlights:
- **`FilterPropertiesUseCaseTest`**: 10 test cases verifying Location, Type, Min/Max Price bounds, Min/Max Area bounds, Status, Configuration (BHK), Search query substring matching, Multi-criteria AND conjunctions, and Empty matching.
- **`SubmitInterestUseCaseTest`**: 5 test cases verifying Name length validation, 10-digit mobile number format, RFC-compliant email regex validation, message length validation, and Room insertion.
- **`AddPropertyUseCaseTest`**: 3 test cases verifying validation rules and insertion of new property listings.
- **`UpdatePropertyUseCaseTest`**: 2 test cases verifying validation and updates to existing properties.
- **`DeletePropertyUseCaseTest`**: 2 test cases verifying deletion from the repository.
- **`GetOwnerInterestsUseCaseTest`**: 3 test cases verifying data isolation between `owner_01` and `owner_02`.
- **`LoginUseCaseTest`**: 5 test cases verifying User and Property Owner authentication flows and error scenarios.

**Test Summary: 30 passed, 0 failed, 100% success rate.**

---

## 🚀 How to Build & Run

### Prerequisites
- Android Studio Ladybug (or newer)
- JDK 17
- Android SDK Platform 35 / Build Tools 35.0.0

### Command-Line Build
```bash
# Clean and run all 30 unit tests
./gradlew test

# Build Debug APK
./gradlew assembleDebug

# The generated APK will be located at:
# app/build/outputs/apk/debug/app-debug.apk
```

---

## 📌 Important Prototype Disclosures & Assumptions
1. **Local Authentication**: Authentication is completely local and dummy based on the assignment specification.
2. **Fresh Start Navigation**: The app always starts directly at the Login screen on launch.
3. **Local Persistence**: Room SQLite is used as the single source of truth without any remote server or Firebase.
4. **Dummy Data**: All property records, images, owner names, and contact details are realistic dummy mock data created solely for demonstration purposes.
