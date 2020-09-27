# Duke User Guide

## Usage
This is a Personal Assistant Chatbot that helps a person to keep track of various tasks.

## Features 
1. Bye
2. List
3. Done
4. Delete
5. Find
6. Todo
7. Deadline
8. Event

## 1. Bye

### `bye` - exit the program

It first say goodbye to the user, then exit the program.

Example of usage: 

`bye`

Expected outcome:

`Bye. Hope to see you again soon!`

## 2. List

### `list` - list out the tasks

It will list out all the tasks that are saved.

Example of usage: 

`list`

Expected outcome:

`Here are the tasks in your list:`

`1. [T][✘] homework`

`2. [D][✘] project (by: Sep 9 2020, 7.00 PM)`

## 3. Done

### `done (index)` - marks task as done

It will mark a particular task specified by the user as done.

Example of usage:

`done 2`

Expected outcome:

`Nice! I've marked this task as done:`

`[D][✓] project (by: Sep 9 2020, 7.00 PM)`

## 4. Delete

### `delete (index)` - deletes a task

It will delete a particular task specified by the user.

It will show the total number of tasks left.

Example usage:

`delete 2`

Expected outcome:

`Noted. I've removed this task:`

`[D][✓] project (by: Sep 9 2020, 7.00 PM)`

`Now you have 2 tasks in the list.`

## 5. Find

### `find (keyword)` - searches all tasks that contain the keyword

It will find all the tasks that contains that keyword.

It will list out all the relevant tasks after that.

Example usage:

`find home`

Expected outcome:

`Here are the matching tasks in your list:`

`1. [T][✘] homework`

`2. [T][✘] home`

## 6. Todo

### `todo (description)` - adds a todo task

It will add and save a todo task.

It will show the total number of tasks currently.

Example usage:

`todo homework`

Expected outcome:

`Got it. I've added this task:`

`[T][✘] homework`

`Now you have 1 task in the list.`

## 7. Deadline

### `deadline (description) /by (yyyy-MM-dd HHmm)` - adds a deadline

It will add and save a deadline with a date and a time.

It will show the total number of tasks currently.

Example usage:

`deadline project /by 2020-09-09 1900`

Expected outcome:

`Got it. I've added this task:`

`[D][✘] project (by: Sep 9 2020, 7.00 PM)`

`Now you have 9 tasks in the list.`

## 8. Event

### `event (description) /at (yyyy-MM-dd HHmm) to (HHmm)` - adds an event

It will add and save an event that starts and end on the same day.

It will show the total number of tasks currently.

Example usage:

`event meeting /at 2020-09-09 1900 to 2000`

Expected outcome:

`Got it. I've added this task:`

`[E][✘] meeting (at: Sep 9 2020, 7.00 PM to 8.00 PM)`

`Now you have 10 tasks in the list.`