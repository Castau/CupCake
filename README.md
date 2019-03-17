<img align="right" width="100" height="100" src="https://i.imgur.com/HYFx3gH.png">  

Cupcake
======
Made by [4 students](https://github.com/Castau/CupCake/graphs/contributors) of Computer Science AP, CPHBusiness, Kgs. Lyngby, Denmark.  
This is the repository for our first project of the 2nd semester.  

#### Project description  
*"(...)develop a simple web-shop using MySql database, java servlets and jsp pages on the backend and html, css and javascript on the frontend."* ([direct link](https://docs.google.com/document/d/1XKK1GkVE-GtCPGEoVJ2SN4qHpfJnU9j7arugQv2-JfY))

#### Result  
The program can be found online <a href="http://207.154.233.238" target="blank">here</a>.  
The javadocs for the program can be found [here](https://castau.github.io/CupCake/).  
Project turn-in in form of a [program report](https://github.com/Castau/CupCake/raw/master/_extra/CupcakeRapport.pdf).

#### Project history
Week 1: We were advised to create this program using Servlets, the HttpResponse/Request classes and HTML/css only.  
Week 2: We were taught JSP and promptly changed our html and several of our servlets actions. At the same time we upgraded to a global CSS stylesheet. We also included bootstrap on most pages, mostly columns for viewport handling.

**Discussion**  
There was a lot of consideration and thought about how the classes and the program came to be, especially the architecture.  
At this time, we have yet to be taught about program architecture. In this situation we take use of [Three-tier architecture](https://en.wikipedia.org/wiki/Multitier_architecture#Three-tier_architecture) and we considered using MVC. 

We have yet to be taught Javascript, something that this project would definitely benefit from. 
We take use of a [Frontcontroller](https://en.wikipedia.org/wiki/Front_controller) but handle our wrong URL paths by a) checking session and b) sending the user to the front page. We considered adding an actual `error 404` page.  
More discussion can be found in the program report.

### Initial development thoughts
**Initial database layout:**  
(Changed during process)  
<img src="https://i.imgur.com/Xabkifb.png" alt = "image of database diagram" height="500" width="500"/>  
**Initial class diagram**  
(Changed during process)  
<img src="https://i.imgur.com/EcuRNWZ.png" alt="image of class diagram" height="750" width="500"/>


Overview of fulfilled requirements
----
See program report (listed above) for full details, including relevant diagrams (ER, navigation, class & sequence).
