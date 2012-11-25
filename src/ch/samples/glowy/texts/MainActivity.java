/* Copyright © 2012 Chaitanya Chandurkar All Rights Reserved
*
* This file is part of "Glowing Text Animation".
*
* Glowing Text Animation is free software:
* you can redistribute it and/or modify it under the terms of the GNU General
* Public License as published by the Free Software Foundation, either version
* 3 of the License, or (at your option) any later version.
*
* This program is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
* GNU General Public License for more details.
*
* You should have received a copy of the GNU General Public License
* along with this program. If not, see <http://www.gnu.org/licenses/>.
*
*/


package ch.samples.glowy.texts;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.graphics.Color;
import android.util.Log;
import android.view.Menu;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

	private static final String TAG ="Glowing Text Example";
	
	TextView textView;
	Button button;
	
	float	startGlowRadius 	= 25f, 
			minGlowRadius 		= 3f,
			maxGlowRadius 		= 15f;
			
	// Create an Instance of GlowingText class;
	GlowingText glowText,glowButton;
	
	// Create instance of Activity
	MainActivity activity =this;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // Instantiate Views
        textView 	= (TextView) findViewById(R.id.glowingtext);
        button 		= (Button) findViewById(R.id.glowButton);
        
        // Set Text Size
        textView.setTextSize(30);
        button.setTextSize(25);
        
        // Start Glowing :D
        glowText = new GlowingText(
        					activity,				// Pass activity Object
        					getBaseContext(), 		// Context
        					textView, 				// TextView
			        		minGlowRadius,   		// Minimum Glow Radius
			        		maxGlowRadius, 			// Maximum Glow Radius
			        		startGlowRadius,		// Start Glow Radius - Increases to MaxGlowRadius then decreases to MinGlowRadius.
			        		Color.BLUE,				// Glow Color (int)
			        		1); 					// Glowing Transition Speed (Range of 1 to 10)
        
        
        glowButton = new GlowingText(
							activity,				// Pass activity Object
							getBaseContext(), 		// Context
							button, 				// Button View
			        		minGlowRadius,   		// Minimum Glow Radius
			        		maxGlowRadius, 			// Maximum Glow Radius
			        		startGlowRadius,		// Start Glow Radius - Increases to MaxGlowRadius then decreases to MinGlowRadius.
			        		Color.RED,				// Glow Color (int)
			        		3); 					// Glowing Transition Speed (Range of 1 to 10)

        // You can also use to set data dynamically
        glowText.setGlowColor(Color.WHITE);  //(int : 0xFFffffff)
        glowText.setStartGlowRadius(5f);
        glowText.setMaxGlowRadius(15f);
        glowText.setMinGlowRadius(3f);
        
        // You can use following methods to retrieve current data
        Log.d(TAG,"Current Glow Radius: "	+glowText.getCurrentGlowRadius());
        Log.d(TAG,"Max Glow Radius: "		+glowText.getMaxGlowRadius());
        Log.d(TAG,"Min Glow Radius: "		+glowText.getMinGlowRadius());
        Log.d(TAG,"Glow Color: "			+glowText.getGlowColor());
        Log.d(TAG,"Glow Transition Speed: "	+glowText.getTransitionSpeed());
  
    }

    @Override
    public void onDestroy(){
    	super.onDestroy();
    	// Don't forget to use this.
    	glowText.stopGlowing();
    	glowButton.stopGlowing();
    }
   
}
