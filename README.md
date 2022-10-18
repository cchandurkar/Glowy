# [Unmaintained]
Though this api is pretty basic and probaly would just work out of the box, this is no longer under development or maintained.

# Glowing Text Animation API

<p>This is an API for Android Programmers.<br /> 
Using this API you can make your <b>TextView</b> and <b>Button</b> text Glow with color of your choice.
</p>


## Usage

### Step 1 : Initialize Variables 




`````java
// TextView which is to be glow
TextView textView;

// Create instance of Activity
MainActivity activity = this;

float       startGlowRadius = 6f,         // Glowing starts with this Intensity
			minGlowRadius   = 3f,         // Minimum Glowing Intensity
			maxGlowRadius   = 15f;        // Maximum Glowing Intensity

// Create instance of GlowingText
GlowingText glowText;
`````
### Step 2 : Instantiate GlowingText class
* Obviously you must do it inside OnCreate 

`````java
glowText = new GlowingText(
		activity,           // Pass activity Object
		getBaseContext(),   // Context
		textView,           // TextView
		minGlowRadius,      // Minimum Glow Radius
		maxGlowRadius,      // Maximum Glow Radius
		startGlowRadius,    // Start Glow Radius - Increases to MaxGlowRadius then decreases to MinGlowRadius.
		Color.BLUE,         // Glow Color (int)
		1);                 // Glowing Transition Speed (Range of 1 to 10)  (fast ... slow)
`````
<i> And it starts Glowing ...  </i>

### Step 3 : Don't Forget
* method <b>stopGlowing()</b> should be called for each and every instance of <i>GlowingText</i> class.

`````java
@Override
public void onDestroy(){
    super.onDestroy();
    // Don't forget to use this.
    glowText.stopGlowing();
}
`````


### Inbuilt Methods You Can Use
`````java
 // You can use these methods to change glowing attribute dynamically.
 glowText.setGlowColor(Color.WHITE); 
 glowText.setStartGlowRadius(10f);
 glowText.setMinGlowRadius(2f);
 glowText.setTransitionSpeed(1);

 // You can use following methods to retrieve current data
 Log.d(TAG,"Current Glow Radius: "    +glowText.getCurrentGlowRadius());
 Log.d(TAG,"Max Glow Radius: "        +glowText.getMaxGlowRadius());
 Log.d(TAG,"Min Glow Radius: "        +glowText.getMinGlowRadius());
 Log.d(TAG,"Glow Color: "             +glowText.getGlowColor());
 Log.d(TAG,"Glow Transition Speed: "  +glowText.getTransitionSpeed());
`````
