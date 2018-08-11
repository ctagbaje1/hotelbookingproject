This project is used for automation testing of Hotel Booking website.

It is a gradle project and can be build using any IDE such as eclipse or intellij
or it can also be build from command line.

To execute the project within your IDE, right click on the project and click Run As > TestNG Test
The components of my framework are Library- Assertion, ConfigLibrary, GenericLibrary, ProjectSpecificLibrary, Modules.
Drivers folder, Jars folder,Screenshots(ALSO USED FOR VALIDATION),Page Object Model with Page Factory

In the real word Framework should be aimed towards the less technical people so Non Technical testers can be involved in code,
training period of using the tool can be reduced,by using Cucumber to write the feature files using Gherkin Language(using Given, When,And, Then)

Also ideal locator to use should be css selector for performance, but however because this is just a single page this has been ignored
in this case, aslo for a dynamic webpage should use xpath selector

Report generated are stored in project folder(/hotelbookingproject/src/main/java/report) while screenshots are under test-output folder
(/hotelbookingproject/HotelBookingNoDeposit.jpg and /hotelbookingproject/HotelBookingWithDeposit.jpg)

To run test on different browser go to config.properties and change browser name to either chrome or iexplorer or firefox

Values used to run test was driven through property file(config.properties) because a good practise is to stop people going into your code, as breakage might occur unintentionally.


-----------   Manual Testing of Site ------------------------------------------------------
A- Functional testing
 1- NO Validation message OR red border line around Firstname/lastname/price field if blank and rest of the fields are filled
 2- Funny characters allowed for firstname/lastname field(should be limited to (',space and -)
 3- NO restriction on number of characters allowed for firstname/lastname/price field(should be 2-50 characters)
 4- NO Validation message OR red border line around price text field when invalid character/s entered say(5,0)
 5- NO restriction on numbers allowed for the price text field
 6- Past Date should be greyed out when using the date-picker for check-in/check-out when form filled say for 10-08-2018,
    customer should not be able to check-in when the date has passed
 7- Saved button should be disabled when questions set is not filled in correctly
 8- Test with browser back/forward/refresh arrow to see if during playback, records are been retained
 
 B- Cross browser testing
 1- testing across Internet explorer, Firefox and Chrome interms of Functional and UI testing
 
 C- Database testing
 1- Using SQL to interrogate the database to make sure datas' are been displayed correctly, making sure there is communication 
 flow from the front end to backend
 2- Making sure database constraints are also not been violated
 3- Business logics are also not violated
 
 D- Mobile testing(ios/android)
 1- functional testing using a mobile device- Can the form be filled 
 2- UI testing
 3- Performance testing
 4- New Performance testing
 5- Interruption
  note:  For Now Hotel Bookings not possible through mobile devices(future test)
 
 E- Performance testing
 1- When using the keyboard tab key to move from one field to another response time is less than 1 sec
 which is good
 2- Hotel booking/s created the response time for it to show back up on the screen is say 3-5 sec interms of performance 
   it is bug could need some tunning
   
 F- Security testing
 1- could use a tool like Zapp proxy to look out for high SQL iNJECTION/XSS(cross site scripting)
 2- Should be able to check logs to make sure call to an action is recorded with operators name for security purpose
 3- Logs file should be available for reference purpose
 
 G- UI testing
 1- looking out for font,color,alignment,watermark,border,text etc
 2- Title of page should start with Capital letters(say Hotel Booking Form and not Hotel booking form)
 
 H- Exploratory testing
 1- To understand about the functionality of the web site , i had to explore it at the same time carrying 
    out my test
    
 I - Smoke test(baby regression test)
 1- Had to make sure the product lights up- basic functionality is working
 
 J- Accessibility testing   
    It is performed to ensure that the application being tested is usable 
    by people with disabilities like hearing, color blindness, old age and other disadvantaged groups.
    1- Use of Chrome Vox to find out if people with poor sight can use the application - OK
    2- Able to fill the question set using just the keypad without having to use the mouse
    3- Can navigate from one text filed to the next using just the keypad
    
  K- Load Testing
  1- To find out when performance of the application begins to degrade when too many people are using
     the application
     
  L- Usersability Testing
  1- Looking out for user friendliness of the application, in terms of this, the application needs tweaking in areas like 
     Trigger error message(validation message)
  2- Has to be obvious to customers what they have to do next, to make it more user friendly if there are issues with form filling
     buttons for creation say save button should be disabled
     
   M- Reliability testing
   1- To identify numbers of failures when call to action for creation and deletion
      Bookings can be done/undone easily when right datas' are supplied and deleted
      This is an indication that the system is reliable, no crashing observe over a long period of time
   
   N- Component Integration testing(commnication flow between question set)
   1- component integration test between question set say price and deposit, enter price say 100 and 
      select from drop down list for deposit to be false, expected outcome should be
      ** Trigger error message to be displayed to user or
      ** Save button to be disabled to notify unintentional error
     
     
     ********************************** (possible Future test) *********************************
   O- Recovery testing
   1- While application is running restart computer and check for validness of the application data 
      integrity
   2- When application is recieving data from connecting network unplug the cable afterwards plug back and see
     if it will continue to recieve data
     
   P- API testing
   1- Verify if the API triggers some other event or calls another API. The Events output should be tracked and verified
   2- Verify if the API's does not return anything
   3- Return Value based on input condition - The return value from the API's are checked based on the input condition
   4- Verify if the API is updating any data structure  
      
          
   
 
