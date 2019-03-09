# MiniCad
A implementation of a basic CAD(Computer-Aided Design) using Java.It can draw lines, triangles, rectangles, diamonds, circles and n-nodes polygons on a canvas and it can fill them with a certain color resulting in a PNG IMAGE.

The program gets its input from a text file(input.txt).Firstly the input files contains the number
of shapes to be drawn and then it contains information about this shapes.
Note:The first shape is always the CANVAS on top of which the other shapes will be drawn.
Note:A test input file is included in the repository(input.txt) and the result of the program
can be viewed in drawing.png.

The parameters that each shape has in common are:
line -> the color of the line used to dra the outline of the shape
transpLine -> the transparency of the line
fill -> the color of the interior of the shape
transpFill -> the transparency of the fill color

Circle:
x, y -> the center of the circle
radius -> the radius of the circle

Line:
xDown, yDown ; xUp, yUp -> the coordinates of the two points that describe the line.

Polygon:
nrNodes -> the number of Nodes
x1,y1, ..., xn, yn -> the coordinates of the nodes

Square:
Xup, Yup -> the coordinates of the top left node of a sqaure.
dim -> the height and width of the sqaure

Square:
Xup, Yup -> the coordinates of the top left node of a rectangle.
height -> the height of the rectangle
width -> the width of the rectangle

Diamond:
x, y -> the center of the diamond
height -> the height of the diamond
width -> the width of the diamond
