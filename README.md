# Restaurant Menu Application

#### Video Demo https://youtu.be/JRkwmRgHay4

![image](https://user-images.githubusercontent.com/109865132/217551052-d1d70518-6308-4ac0-a215-374ff46d6330.png)

## Description:
This is my Restaurant Menu App created using Android Studio, for the Meta Capstone Project. Using the Jetpack Compose library, this project has a mini full-stack framework that handles the frontend & styling with Compose, as well as the backend with a SQLite database and other configurations.

To run this application, it is advised to have Android Studio downloaded.

#### Restaurant Menu Application Features
For this project, the Restaurant Menu Applicaton allows a user to browse restaurant menu items by fetching API data from a third-party source via HTTP request. From here, the menu items and its data, including image and pricing, are displayed lazily on a scrollable column. 

Upon launch, the application checks for a user, where you can register if there is none. After logging in, you are greeted with a home screen that gets the HTTP request data mentioned above with the menu items. There are three main parts to the home screen, which has a hero component where a user can query for a specific item in the menu, the filter buttons where a user can search for a dish of a specific category, and finally a column that shows each available menu item from the API call. As the filter or query is used, the home page will dynamically search for the requested menu item.

Finally, there is a profile screen that remembers the user data inputted from persistent storage, and the user can also log out if they choose to do so.

#### Navigating the Application
Starting the application, the user is first greeted by the login page - which they must register and log in to have access to the rest of the 
application. Once in the main page of the application, therer are menu items that the user can interact with.
There is a navigation library used that is passed through all the navigatable pages so that the application can keep track of where the user is, and the order that they traversed the pages in.

#### Credits & Citations
This application contains static files provided by Meta from: <br>
https://raw.githubusercontent.com/Meta-Mobile-Developer-PC/Working-With-Data-API/main/menu.json
