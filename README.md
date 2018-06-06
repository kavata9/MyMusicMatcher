# MyMusicMatcher
[Link to deployed app.]()

### This is an appication that a user can be able to carry out music search.

### The following are the specifications of this application:
1. Salon employee can see list of all styl.
2. Upon selecting a stylist, employee should see their details and list of all clients that belong to the stylist.
3. Employee can add new stylist
4. Employee can add clients to a stylist.
5. Employee can update stylist details.
6. Employee can update client details.
7. Employee can delete stylist.
8. Employee can delete client.



### The technologies used are:
1. Java Programming Language
2. Android studio.
3. Gradle

**Set Up and Installation**
1. Download the project folders
> ```
>$ git clone https://github.com/kavata9/Hair-salon
>$ cd hairsalon
>```
2. Change postgres db login details
> ```
> $ cp src/main/java/DbDetailsExample.java src/main/java/DbDetails.java 
> $ gedit src/main/java/DbDetails.java
>```
> Change the class name to DbDetails and the db logins to your credentials
3. Launch
> ```
> $gradle run
>```
> open [http://localhost:4567](http://localhost:4567)

### Need help with deploying Spark java applications visit this [site](https://brianmarete.github.io/blog/java/spark/postgresql/heroku/2017/05/12/deploying-a-spark-java-app-with-a-postgresql-database-to-heroku.html)

### Author:
#### [Agnes Musyoka](https://github.com/kavata9/Hair-salon) 
### License
**MIT License**

Copyright (c) 2018 Agnes Musyoka

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
