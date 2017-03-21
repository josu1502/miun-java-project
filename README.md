# Miun java application project
## About
A system for a fictional restaurant, called Skafferiet. The system uses Android smartphones to take orders and display them at a tablet screen in the kitchen, for the chef. This is a school project for the Mid Sweden University in Sundsvall. Main language used in this project is Swedish. Feel free to use the source code as you please.
## Includes
Project files are found under the folder "Projekt".
* 3 x Android Studio projects for applications.
* 2 x Netbeans Java EE project for webpages.
## Setup instructions
The following things need to be done to get the project to work on your local computer.
### 1. Glassfish
Install Glassfish Server 4.0 in Netbeans.
### 2. Database
Set up a database in Netbans.
* Database name: AntonsSkafferiDB
* Username: anton
* Password: anton

Finish with a clean build and check for possible errors.
### 3. Change file path in AntonsHemsida (Netbeans project)
Change path to images project file destination.
* Open project
* Open ImageForm.java (Source Packages/beans.form/ImageForm.java)
* Update line 37 and 38 with your local path to the images-project
### 4. Compile images project (Netbeans project)
Compile this project once. This project will contain all images uploaded from the admin webpage.
### 5. Compile AntonsHemsida (Netbenas project)
Compile this project to run the webpage. After this both the webpage and admin-page is ready to be used.
### 6. Change local IP in SchemaApplikation (Android Studio project)
Change to your local ip-adress in the files needed.
* Open project
* Open MainActivity.java
* Update line 49 with your local ip-adress
### 7. Change local IP in KitchenApplication (Android Studio project)
Change to your local ip-adress in the files needed.
* Open project
* Open MainActivity.java
* Update line 56 with your local ip-adress
### 8. Change local IP in OrderApplication (Android Studio project)
Change to your local ip-adress in the files needed.
* Open project
* Open ShowOrderActity.java
* Update line 86 with your local ip-adress
* Open Main_course.java
* Update line 49 with your local ip-adress
* Open TabActivity.java
* Update line 59 with your local ip-adress

### Now all projects should be up and running, if they all are connected to the same network

## Special thanks
A special thanks to our teacher Martin Kjellqvist for helping us when we got stuck.


