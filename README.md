# Emlak Alım Sistemi (EMASS)

Emlak Alım Sistemi (EMASS) is a comprehensive real estate application designed to facilitate the buying, selling, and renting of properties. The system aims to provide users with a seamless experience in managing their real estate needs, featuring a user-friendly interface and robust functionalities.

## Table of Contents

- [Features](#features)
- [Technologies Used](#technologies-used)
- [Installation](#installation)
- [Usage](#usage)
- [Contributing](#contributing)
- [License](#license)
- [User Scenarios](#user-scenarios)

## Features

- **User Registration and Authentication**: Secure user registration and login functionality.
- **Property Listings**: Users can view, search, and filter property listings based on various criteria.
- **Property Management**: Users can add, edit, and delete their property listings.
- **Advanced Search Filters**: Search properties by location, price range, type, and other parameters.
- **User Dashboard**: Personalized dashboard for users to manage their listings and view their activity.
- **Responsive Design**: Optimized for both desktop and mobile devices.

## Technologies Used

- **Frontend**: React, HTML, CSS, TypeScript
- **Backend**: Java Spring Boot
- **Database**: PostgreSQL
- **Version Control**: Git, GitHub

## User Scenarios

### Scenario 1: User Registration and Login

#### User: New user  
#### Goal: Register and log in to EMASS

1. **Visit the Homepage**
   - The user visits the EMASS homepage.

2. **Registration Process**
   - The user clicks the **"Sign Up"** button on the homepage.

3. **Completing the Information**
   - The user fills in the required information (name, email, password).
   - After entering the information, the user clicks the **"Complete Registration"** button.

4. **Registration Confirmation**
   - The system confirms the user’s registration and automatically logs them in.

5. **Redirect to Homepage**
   - The user is redirected to the homepage and can access their user panel.
   - In the user panel, the user can update their information, manage their listings, and use other features of the system.

---

### Scenario 2: Listing a Property

#### User: Property owner  
#### Goal: List a new property

1. **Login to User Panel**
   - The user logs into their user panel using previously registered credentials.

2. **Adding a Property**
   - The user clicks the **"Add Property"** button in their user panel.

3. **Filling in Property Details**
   - The user fills in the property details (title, description, price, location, photo).
   - The user ensures that all details are complete and accurate.

4. **Publishing the Listing**
   - After reviewing the information, the user clicks the **"Publish Listing"** button.

5. **Confirmation of Successful Listing**
   - The system confirms that the property has been successfully added and updates the listings.
   - The user can view their new listing and make any necessary edits.

---

### Scenario 3: Searching for Properties

#### User: Home seeker  
#### Goal: Search for properties based on specific criteria

1. **Visit the Homepage**
   - The user visits the EMASS homepage.

2. **Entering Search Criteria**
   - The user inputs the desired location and price range in the search filters.
   - The user can further narrow the search by using additional filters (e.g., number of rooms, property type).

3. **Executing the Search**
   - The user clicks the **"Search"** button after entering the criteria.

4. **Displaying Results**
   - The system displays a list of properties that match the specified criteria.
   - The user clicks on a property to view its details.

5. **Viewing Property Details**
   - The user examines the details of the selected property (images, location map, contact information).
   - The user can add interesting properties to their favorites or directly contact the property owner.

## Installation

To get started with the EMASS project locally, follow these steps:

1. **Clone the repository**:
   ```bash
   git clone https://github.com/yourusername/emass.git
