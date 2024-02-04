## D287 – JAVA FRAMEWORKS

### C.  Customize the HTML user interface for your customer’s application. The user interface should include the shop name, the product names, and the names of the parts.
File Path: src/main/resources/templates/mainscreen.html

Line Number: 14
Changes: Changed Title to "Yip's Retro Games" 

Line Number: 19
Changes: Changed h1 to "Yip's Retro Games"

Line Number: 21 
Changes: Changed 1st h2 to "Custom Parts"

Line Number: 53
Changes: Changed 2nd h2 to "Consoles"



### D.  Add an “About” page to the application to describe your chosen customer’s company to web viewers and include navigation to and from the “About” page and the main screen.
File Path: src/main/resources/templates/about.html
Lines: All
Added the view for the about page. Used the same bootstrap styling as the other pages.

File Path: src/main/java/com/example/demo/controllers/AboutController.java 
Lines: All
Created the showAbout method which returns the view about.html. Used the annotation @GetMapping to map the method 
"showAbout" to handle GET requests for the endpoint "/showAbout"




### E.  Add a sample inventory appropriate for your chosen store to the application. You should have five parts and five products in your sample inventory and should not overwrite existing data in the database.
File Path: src/main/java/com/example/demo/domain/OutsourcedPart.java
Lines: 20-22
Added constructor to simplify future object instantiation.

File Path: src/main/java/com/example/demo/domain/InhousePart.java
Lines: 20-22
Added constructor to simplify future object instantiation.

File Path: src/main/java/com/example/demo/bootstrap/BootStrapData.java
Lines 48-115:
Instantiated 5 Parts and 5 Products using both existing constructors and setter methods. Utilized if/else statement to only
add sample inventory when both the product and part lists are empty.



### F.  Add a “Buy Now” button to your product list. Your “Buy Now” button must meet each of the following parameters:
•  The “Buy Now” button must be next to the buttons that update and delete products.
•  The button should decrement the inventory of that product by one. It should not affect the inventory of any of the associated parts.
•  Display a message that indicates the success or failure of a purchase.

File Path: src/main/java/com/example/demo/controllers/AddProductController.java
Lines: 174-189:
Added the buyProduct method. If the inventory of the item is > 0, decrements the inventory by 1 and redirects to 
confirmationbuyproduct.html, otherwise, redirects to failedbuyproduct.html.

File Path: src/main/resources/templates/mainscreen.html
Lines:89-92
Added the button that calls the buyProduct method. Used a form instead of a standard button 
to utilize the POST request instead of the default GET request.

File Path: src/main/resources/templates/confirmationbuyproduct.html
Simple view with a success message.

File Path: src/main/resources/templates/failedbuyproduct.html
Simple view with a failure message.



### G.  Modify the parts to track maximum and minimum inventory by doing the following:
•  Add additional fields to the part entity for maximum and minimum inventory.
•  Modify the sample inventory to include the maximum and minimum fields.
•  Add to the InhousePartForm and OutsourcedPartForm forms additional text inputs for the inventory so the user can set the maximum and minimum values.
•  Rename the file the persistent storage is saved to.
•  Modify the code to enforce that the inventory is between or at the minimum and maximum value.


### H.  Add validation for between or at the maximum and minimum fields. The validation must include the following:
•  Display error messages for low inventory when adding and updating parts if the inventory is less than the minimum number of parts.
•  Display error messages for low inventory when adding and updating products lowers the part inventory below the minimum.
•  Display error messages when adding and updating parts if the inventory is greater than the maximum.


### I.  Add at least two unit tests for the maximum and minimum fields to the PartTest class in the test package.


### J.  Remove the class files for any unused validators in order to clean your code.