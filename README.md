# Genetic Algorithm
INFO6205, Spring 2019  
Final project, Team 518  

Team members: Siyu Tu, Yiyin Chen and Yue Zheng

# About this project
### Senario: 
Spaceships, like USS Enterprise, are out in the space looking for a planet with a top-value mineral, Krypton, to mine. There are many planets that have Krypton, each with a different amount. The ships wants to find the planet with the highest amount of Krypton based on the signals they receive on their detector. The signal strength is a combination(function) of two factors(variables): 1, distance between the ship and the planet, and 2, the amount of the mineral on the planet. A shorter distance, a larger amount of mineral or both will result in a stronger signal. The only clue they have is the signal strength so they don't have a lot to start with, but here they are. 

### Methods:
1. Genotype (binary gene) -> Phenotype (coordinates)
2. Tournament selection (by fitness)
3. Crossover
4. Mutation
5. Parallelism 

### Result: 
The algorithm returns a XYZ coordinate of the target. Also, the planet rank (in size) can be displayed to show the accuracy of the result. A full report with details can be found in the report.
