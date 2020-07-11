# Toll Booth Simulation
Toll Booth Simulation - The overall goal of the project is to be able to compare different Toll Booth configurations for 6 lanes total of two Toll Booth types:

• Manual Toll Booths - Person operated, Vehicle must come to a complete stop. For Vehicles with any number of axels.

• Automatic Toll Booths- Transponder in Vehicle is "read" by monitor, Vehicle must slow down to 10mph. For 2-axle Vehicles only.
Assume a Vehicle will pick the shortest Toll Booth Line for their Toll Booth type (Manual or Automatic) and a Vehicle does not change Toll Booth Lines. There is a maximum length of a Toll Booth Line of 25 Vehicles. The Simulator will allow the user to configure up to 6 total Toll Booths in any combination of Manual and Automatic (with at least one of each). We will be simulating using Vehicle and arrival data collected at two different times of day, rushhour.txt and nonrushhour.txt (see attachments). Files contain tab delimited Vehicle arrive time, Vehicle axles, and Vehicle toll type ("M" or "A"), one per line, and are sorted in increasing Vehicle arrive time order. More than one Vehicle can arrive at the same time.
Comparisons will be made using the following statistics (you can add other statistics, but these are required):

• The maximum length of each of the Toll Booth Lines during the entire simulation.

• The maximum wait time for each Vehicle of a Toll Booth type (Manual or Automatic) during the entire simulation (wait time is from when a Vehicle arrives until when the Vehicle reaches the Toll Booth).

• The maximum wait time for each Vehicle of a Toll Booth type (Manual or Automatic) during the entire simulation (wait time is from when a Vehicle arrives until when the Vehicle reaches the Toll Booth).
Note, all the last two statistics listed above are calculated from information stored in each Vehicle. You will use the Vehicle and TollBoothLine classes as described below. Make sure to submit these along with your Simulator and SimulatorClient code.
Vehicle User-Defined Class: Create a Vehicle class with the following:

• Instance variables (all integers are fine) for the Vehicle's

o unique ID

o number of axles (to determine the toll rate)

o toll type (String, "A" for automatic, "M" for manual)

o time the Vehicle arrives to the toll booth line

o time the Vehicle gets to the toll booth

o time the Vehicle leaves the toll booth

• A static instance variable to keep track of how many Vehicle objects have been instantiated. Use this for the unique ID for each Vehicle.

• Non-Default Constructor - generates the unique ID, sets the number of axles, toll type, and line arrival time via method parameters, assume default values for the other instance variables at instantiation time.

• Accessor Methods - for each instance variable

• Mutator (set*) Methods - for each instance variable. Check for valid values (>0) and logical relationships between "line arrival time"<"toll booth arrival time" and "toll booth arrival time"<"toll booth leave time". If logical relationships do not exist, set the instance variable to zero.

• toString Method
TollBoothLine (a Queue of Vehicle): We will need a TollBoothLine class to store Vehicle objects waiting in a line. You will need to use the Vehicle class from an earlier lab. Create a TollBoothLine class with the following:

• Instance variables

o array of Vehicle objects to store the line

o integer for the limit for the length of the line (set by the user by argument to the non-default constructor)

o integer for the current number of Vehicle objects in the line.

o integer for the maximum length the line actually gets with Vehicle objects doing a simultation run (this is for comparison purposes between the different toll booth simulations).

• Non-Default Constructor "TollBoothLine(int size)" - sets the limit for the length of the line form the "size" argument, instantiates the array to use for the line to this size, takes default values for "current number of Vehicle objects in the line" and "maximum length the line actually gets".

• Accessor Method - "int getLength()" - returns "current number of Vehicle objects in the line".

• Mutator Methods -

o "boolean addVehicleEnd(Vehicle v)" - copies the Vehicle object passed as an argument to the next available position in the line and returns true (if enough room in the line), else returns false. Also, increments the "current number of Vehicle objects in the line" and possibly updates "maximum length the line actually gets".

o "Vehicle removeVehicleStart()" - If there is no Vehicle objects in the list, return null. Otherwise, return the first Vehicle object in the list and move all the other Vehicle objects up one space in the list. Updates the "current number of Vehicle objects in the line".

o "Vehicle copyVehicleStart()" - If there is no Vehicle objects in the list, return null. Otherwise, return the first Vehicle object in the list. Do not remove the Vehicle

o "boolean replaceVehicleStart(Vehicle v)" - If there is no Vehicle objects in the list, return false. Otherwise, replace the first Vehicle in the list with the Vehicle object passed as an argument..

• toString() Method - output each Vehicle object in the list, one to a line, and output the "maximum length the line actually gets"
The basic idea is the Simulator class (incomplete class provided as attachment) will run a simulation loop for a certain number of seconds. Different events can happen during each second of the simulation. Vehicle objects are created one at a time from the input file, and if it is the arrival time for a Vehicle, the Vehicle is placed in the shortest appropriate (by toll type) Toll Booth Line. When a Vehicle gets to the front of it's Toll Booth Line, the Vehicle leave time is calculated based on an observed delay for the toll type per axle. Once a Vehicle leaves, the next Vehicle in the Toll Booth Line moves up to the Toll Booth. When a Vehicle is DONE (and its booth time and leave time has been updated), it is moved to an array to save all Vehicles for calculating statistics after the simulation.

The SimulatorClient class needs to do the following:

• Dialog to ask user for "rush hour" or "non rush hour" simulation

• Dialog to ask user for number of manual toll booths and number of automatic toll booths (limited to 6 total, with at least one of each)

• instantiate Simulator object

• start the Simulator

• calculate and output the Toll Line Statistics

• calculate and output the DONE Vehicle Statistics

The Simulator class needs the following methods:

• Method to read, create and return a Vehicle, or return null

• Method to find and return the shortest TollBoothLine of the given tollType

• Method to calculate and output the Toll Line Statistics

• Method to calculate and output the DONE Vehicle Statistics
