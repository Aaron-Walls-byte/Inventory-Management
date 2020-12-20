# Inventory-Management

This app was designed to keep track of items with a persistent SQLite data base. It is a stand alone application that users can items too and keep track. The application features a login sceen, item menu, a create item dialog, and a navigation drawer. Navigation was designed to be intuitive with a floating action button to create new items and on screen icons to telegraph the function of the application. 

I used Android studios model activities to begin and added an SQLite database to the application. The login screen is function, although a new workflow will be needed to add new users to the application in a way that makes sense. Adding items work, but the list does not update the UI as of this version. More testing will be required to fine tune this critical function.

During the application development process, creating the database for the login screen was the hardest challenge. First I started with SQLite, but after reading I decided to move to the Room API, only to move back because Android kept having build issues. Using the viewModel, changes to the UI can be updated. 

The specific component of this process that I thought I did well on was the UI component. I used the Android development guide to create a functional and visually pleasing application.
