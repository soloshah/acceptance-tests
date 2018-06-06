# Cucumber tests

## Setup

1. clone the repo `git clone git@dps-gitlab.service.nhsbsa:CSS/comp-man-acceptance-tests.git` (ssh) or `git clone https://dps-gitlab.service.nhsbsa/shabh/CCCHS_AT.git` (If you are using https your personal clone link is foun on the project page)
2. fetch the latest tags `git fetch --tags`
3. checkout the latest tag e.g. `git checkout 0.0.x`
4. import the maven project into your favourite IDE
5. update the project and force update snapshots/releases
6. Install the Cucumber JVM plugin for eclipse Help > Install New Software > Click Add  
set Name - Cucumber JVM  
set Location - http://cucumber.github.com/cucumber-eclipse/update-site  
Complete the installation for the Cucumber Eclipse plugin

or Enable Cucumber for Java plugin for Intelij
File > settings > plugins > Cucumber for Java (you may need to install this)
7. In the project folder structure open any feature file from src > test > resources > features
8. run the features

## Running via Maven

Running the tests via maven allow run time arguments to passed in easily and enable more advanced report to be created when test have been run.

1. View run configurations
2. Select Maven Build >> New
3. Set Base directory `${workspace_loc:/cucumber-template}`
4. Set Goals `verify -Dcucumber.options="src/test/resources/features/ --tags @smoke --no-dry-run"` replacing the folder and tags as requires
5. Apply and Run

## selenium-cucumber-java

selenium-cucumber : Automation Tesing Using Java

selenium-cucumber is a behavior driven development (BDD) approach to write automation test script to test Web.
It enables you to write and execute automated acceptance/unit tests.
It is cross-platform, open source and free.
Automate your test cases with minimal coding.
[More Details](http://seleniumcucumber.info/)

## Documentation

* [Installation](doc/installation.md)
* [Predefined steps](doc/canned_steps.md)


## Predefined steps

By using predefined steps you can automate your test cases more quickly, more efficiently and without much coding.

The predefined steps are located [here](doc/canned_steps.md)

## Custom steps

Create a new feature file for the scenario you wish to test using your custom steps
Create you scenario, write you steps and run the feature file to auto generate the steps
Copy the steps into a step defintion file
Add the methods you need to complete the step, you can use native selenium methods e.g.

`driver.findElement(By.id(you_id_here)).click();`

or using the selenium-cucumber API's e.g

`predefinedSteps.click("id", "you_id_here");`


## selenium-cucumber-java API's

By using selenium-cucumber API's you can write code for your custom steps more efficiently.

The selenium-cucumber API's steps are located [here](doc/selenium-cucumber-java-API.md)


License
-------

The MIT License

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the 'Software'), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED 'AS IS', WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
