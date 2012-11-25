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

	// Create an Instance of GlowingText class;
	GlowingText glow;
	MainActivity activity =this;
	private static final String TAG ="Glowing Text Example";
	
	TextView view;
	Button glowButton;
	float	startGlowRadius 	= 25f, 
			minGlowRadius 		= 3f,
			maxGlowRadius 		= 15f;
		
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        view = (TextView) findViewById(R.id.glowingtext);
        glowButton = (Button) findViewById(R.id.glowButton);
        
        view.setTextSize(30);
        glowButton.setTextSize(25);
        
        glow = new GlowingText(
        					activity,
        					getBaseContext(), 	// Context
        					view, 					// View (TextView or Button ONLY)
			        		minGlowRadius,   		// Minimum Glow Radius
			        		maxGlowRadius, 			// Maximum Glow Radius
			        		startGlowRadius,		// Start Glow Radius - Increases to MaxGlowRadius then decreases to MinGlowRadius.
			        		Color.WHITE,			// Glow Color (int : 0xFFffffff)
			        		1); 					// Glowing Transition Speed (Range of 1 to 10)
        
       
      
        glow.setGlowColor(Color.BLUE);
        
        /*
        // You can also use to set data dynamically
        glow.setStartGlowRadius(5f);
        glow.setMaxGlowRadius(15f);
        glow.setMinGlowRadius(3f);
        
        // You can use following methods to retrieve current data
        Log.d(TAG,"Current Glow Radius: "	+glow.getCurrentGlowRadius());
        Log.d(TAG,"Max Glow Radius: "		+glow.getMaxGlowRadius());
        Log.d(TAG,"Min Glow Radius: "		+glow.getMinGlowRadius());
        Log.d(TAG,"Glow Color: "			+glow.getGlowColor());
        Log.d(TAG,"Glow Transition Speed: "	+glow.getTransitionSpeed());
        */
        
      
        
    }

    @Override
    public void onDestroy(){
    	super.onDestroy();
    	// Don't forget to use this.
    	glow.stopGlowing();
    }
   
}
