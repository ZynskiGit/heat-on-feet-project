# heat-on-feet-project
Team: Alexander Korczynski
Members: Alexander Korczynski (Section 4)
This project aimed to create a database holding a user and their collection of footwears. The idea would be that a user could yield a collection of footwear and express
it throught this database. Then user would be able to name the brands of their footwear, the materials involved, and the colors involved. Along with this the user would
be able to have any number of footwears in their collection. The types available to the user in terms of specifying footwear would be:
SNEAKER, BOOT, SANDAL, SLIPPER, DRESS, SOCK.
UML Class Diagram: file:///C:/Users/alexa/Downloads/db_design_final_project_UML.pdf
The User data model includes the fields: firstName, lastName, username, password, email and dateOfBirth. The setters and getters are present in the model to retrieve such
information, and the constructors are present to construct a new User object.
The first domain object model is footwear, which then holds one to many relationship with other domain objects with Brand, Material and Color. Footwear holds a many to one
relationship with the User. Footwear contains a boolean field for whether the footwear is made to be active, price for cost of the footwear, name for the name, style for its type,
and lists containing the colors, brands and materials involved in the footwear.
The User holds a one to many relationship with footwears where a user can have various styles as well as many different footwears of various brands, colors and materials.
The Domain object Footwear holds a OneToMany relationship with Brands, colors and materials while Brands, Colors and Materials holds a ManyToOne relationship with Footwear
The portable enumerations are the type of Footwear being:SNEAKER, BOOT, SANDAL, SLIPPER, DRESS, SOCK.
The User interface requires a username, password, first and last name, email, and date of birth.


