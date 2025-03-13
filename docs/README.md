# Jake User Guide
Jake is a app for task management and optimised for user who prefers command line interface.
- [Quick Start](#quickstart)
- [Features](#features)
  - [Add Task](#add-task)
    - [`todo`](#todo)
    - [`deadline`](#deadline)
    - [`event`](#event)
  - [List Task: `list`](#list-task)
  - [Mark Task](#mark-task)
    - [`mark`](#mark)
    - [`unmark`](#unmark)
  - [Delete Task: `delete`](#delete-task)
  - [Find Task: `find`](#find-task)
- [Command Summary](#command-summary)
## QuickStart
1. Ensure you have Java 17 or above installed in your Computer. 
2. Download the latest `jake.jar` from [here](https://github.com/Lyam-T/ip/releases/tag/A-Release)
3. Copy the file to the folder you want to use as the home folder for Jake.
4. Open a terminal and navigate to the folder where the `jake.jar` is located, and run the command `java -jar jake.jar`
## Features
Please note that <> denotes a required field, exclusive of the brackets.
### Add Task
#### `todo`
Add a todo task to the task list.  
Format: `todo <DESCRIPTION>`
#### `deadline`
Add a deadline task to the task list.  
Format: `deadline <DESCRIPTION> /by <DATE>`  
`<Date>` Format: `YYYY-MM-DD HH:MM`, eg `2021-09-17 23:59`
#### `event`
Add an event task to the task list.  
Format: `event <DESCRIPTION> /at <DATE>`  
`<Date>` Format: `YYYY-MM-DD HH:MM`, eg `2021-09-17 23:59`
### List Task
List all tasks in the task list.  
Format: `list`
### Mark Task
##### `mark`
Mark a task as done.  
Format: `mark <INDEX>`  
`<INDEX>` refers to the index number shown in the displayed task list, ie starting from 1.
##### `unmark`
Unmark a task as done.  
Format: `unmark <INDEX>`  
`<INDEX>` refers to the index number shown in the displayed task list, ie starting from 1.
### Delete Task
Delete a task from the task list.  
Format: `delete <INDEX>`  
`<INDEX>` refers to the index number shown in the displayed task list, ie starting from 1.
### Find Task
Find tasks that contain the keyword.
Format: `find <KEYWORD>`  
`<KEYWORD>` is case-sensitive, and is referred to the description of the task. See [Add Task](#add-task) for more information about description.
## Command Summary
Command | Fomat | Example
--------|------------------|---------
Add Task | `todo <DESCRIPTION>` <br/> `deadline <DESCRIPTION> /by <DATE>` <br/> `event <DESCRIPTION> /from <DATE> /to <DATE>` | `todo read book` <br/> `deadline homework1 /by 2021-09-17 23:59` <br/> `event party /from 2021-09-18 18:00 /to 2021-099-18 23:00`  
List | `list` | `list`  
Mark | `mark <INDEX>` <br/> `unmark <INDEX>` | `mark 1` <br/> `unmark 1`  
Delete | `delete <INDEX>` | `delete 1`  
Find | `find <KEYWORD>` | `find book`  

[BACK TO TOP](#jake-user-guide)
