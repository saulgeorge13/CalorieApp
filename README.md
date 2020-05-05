# Calorie Tracker

## by Saul George

A calorie tracker meant for students of the University of British 
Columbia who live in a first year residence.
The idea for this project came to me through my struggles to maintain a 
healthy diet while burdened with the residence meal plans.

This project will help students with the residence meal plan achieve their 
fitness goals related to dieting. 

##User Stories
As a user I want to be able to; 

Phase 1:
- add my consumed meals 
- view calories consumed today
- set a daily calorie intake restriction
- save a meal as a favourite 

Phase 2:
- save my consumed meals when closing the app
- reopen the app to continue tracking my calories by loading my data
- reset my consumed meals

##Instructions for Grader 
Phase 3

Running Main opens the main menu while loading any previously saved user
- Clicking add meal adds a Meal (X) to User (Y) 
- Clicking add Fave Meal adds the previously input favourite meal to User (Y)
- Clicking Display info displays all the Meals(X) that have been added to User(Y)
- Add Fave Meal, Reset Meal and Save and Quit play a sound when clicked as they don't 
display anything, this allows the user to known the task was carried out
- Running the main program automatically loads data stored on file, clicking
save and quit saves the data to the file before closing the application
(takes a few seconds sometimes).


Phase 4: Task 2
- Refactored the Meal class to make it more robust
- Now uses IllegalValueException and IllegalLengthException to ensure adherance
to "required" specifications of the constructor.

Phase 4: Task 3

UML design diagram added to the root

Problems
- NewUserPanel, AddMealPanel and SetMaxCalPanel were saving the user data in 
addition to their main tasks (Cohesion issue).
- Doesn't appear to be any coupling issues due to minimum associations and most
relationships merely being dependencies.

Fixes
- Above mentioned classes no longer call the writer, data is only saved when quitting
- Completing phase 4 task 2 fixed cohesion issues with the adding of meals by 
using the helper functions. 

