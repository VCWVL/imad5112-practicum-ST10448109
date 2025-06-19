Playlist Manager App
Student Name: Bryton Rajah
Student Number:
Module: IMAD 
 
The  GitHub Link
The link to the GitHub repository with my full source code: 
Enter your repository link here-
 
About my playlist  Manger App
This Android application was built using Kotlin Programming in Android Studio. This app will allow a user to add up to four songs to a playlist, including the song title, artist name, a rating (1–5), as well as a comment. The app will store this information in arrays and then uses loops to display the data and then calculate the average rating of the songs.
 
In this app there are two main screens:
- The main screen: Where users can enter and add songs.
- The detailed view screen: Where all songs are displayed, and then the average rating will be shown.
 
The Code Overview
In the Main Activity
- this will  accept a user’s input and validate it.
- it will store the song details whilst using four parallel arrays.
- This will displays a message if any input is missing or the playlist is full.
- This will allow a user to navigates to the next screen or exits the app.
 
 In the detail view activity
- It receives the data that is passed from Main Activity.
- It displays each song's details using a loop.
- It will calculates and shows the average rating in the app.
- This will allows the user to go back to the main screen.
 
 Screenshots and Descriptions
 
1. Source Code
The Main Activity screen
Screenshots/MainActivity
This file will handle the user’s input, the  validation, and the screen navigation.
 
The Detailed View Activity screen
(screenshots/DetailedViewActivity
This file will  displays the playlist and then it  calculates the average rating.
 
 2. The app Screens from the emulator
 
The main screen
This is where the user can add songs and then gets navigated to the detailed view or the exits.
 
Add Song Example
This is an image of a provided example of what it will look like when a user is entering a song and adding it to their playlist.
 
Playlist View
This shows all the songs with the artist, rating, and the comment, plus the average that was calculated.
 
Playlist Full Message
This will display a message when trying to add more than four songs into the app
 
Invalid Rating Message
This shows a warning if the rating of the number is not a number between 1 and 5.
 
In Summary
-This app uses arrays and loops as its required.
- It handles all input validation and errors properly.
- The layout is clear and simple to use.
- The navigation between the screens works smoothly.
