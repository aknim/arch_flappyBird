/*
$$$$$$$$$$$$$$$$$$
$$$REQUIREMENTS$$$
$$$$$$$$$$$$$$$$$$


Objects List:
* Bird	     : maintains its currY, currSpd
* Pipe	     : maintains its uh, dh, spd
* PipeMananger : maintains lists of pipes and keep moving them when asked, removing if required and adds new when asked
* Input	     : asynchronously captures user clicks
* Display    : display the canvas, the pipes, the birds
* GameConfig : constants like screen size, which are different for different games
* RuleBook   : that tells rules like collision, which can be different for different games
* Controller : orchestrates input from Input, and gets bird to compute its next place. Checks with rulebook if it is okay. If matches, asks the bird to move. If not, does accordingly (probably a collision & gameover)
	       orchestrates the PipeManager to move the pipes
	       keeps ticking(sleeping)
	       orchestrates Display to update the display
* Composite  : ceates map, pipes, bird, input, display, gameconfig, rulebook and controller and starts the controller
* Main	     : creates composite, and GameConfig and passes this to the composite
*/
/*
**********
***Bird***
**********

*Knows: currY, currSpd
*Does: computeNextPos, moveNextPos
*Collabs: None
*/

/*
**********
***Pipe***
**********

*Knows: topY, bottomY, speed, x
*Does: computeNextPos
*Collabs: None
*/

/*
*****************
***PipeManager***
*****************

*Knows: 
*Does: movePipes, adds new pipe, NOT destroys BUT RECYCLES pipe when asked (
*Collabs: Pipe

OBJECT POOL/RECYCLER PATTERN: we won't destroy pipes, but will recycle them. Our game is high speed, around 60FPS physics loop game. Letting garbage collector delete pipes every few seconds creates MICRO-STUTTERS & PERFORMANCE DROPS.
*/
/*
****************
***GameConfig***
****************

*Knows: w, h, birdSpd, pipeSpd, pipeProbability, maxPipes
*Does: provide read-only access to these
*Collabs: None
*/
/*
**************
***RuleBook***
**************

*Knows: 
*Does: check methods: checkBirdCollision, 
*Collabs: 

We pass only the coordinates information, not the actual bird and pipeManager objects
1. this prevents collab between rulebook and the objects
2. we don't keep the processing of collision rules in controller. controller just have Single Responsibility of orchestrating, and not heavy or other computations like collisions
*/

/*
***********
***Input***
***********

*Knows: last User Input
*Does: Asynchronously caputer teh user input
*Does: When asked gives the input to the controller
*Collab: None
*/

/*
*************
***Display***
*************

*Knows: 
*Does: Paints the environment. Paint the pipes. Paint the bird.
*Collab: None
*/

/*
****************
***Controller***
****************
*Knows: 
*Does: Orchestrates and receives user input
*Does: Orchestrates and tells display to display bird, pipes, environment
*Does: Checks with rulebook if positions are allowed, or what they mean
*Does: Confirms brid or pipe or whatever to move
*Does: Keeps sleeping. Keeps calling other things according to their speed
*Collab: Bird, PipeManager, Input, Display
*/
/*
***************
***Composite***
***************
*Knows:
*Does: Creates controller. Creates bird, pipeManager, Input, Display, GameConfig, Rulebook and passes to Controller
*Does: Starts the controller
*Collab: all of the above
*/
/*
**********
***Main***
**********
*Knows:
*Does: Passes game info to composite
*Collab: Starts the composite
*/
