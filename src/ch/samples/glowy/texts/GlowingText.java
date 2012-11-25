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

import java.util.Random;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class GlowingText{

	private Context mContext;
	private Activity activity;
	
	private View view;	
	
	private float startGlowRadius,
	              minGlowRadius,
	              maxGlowRadius,
	              currentGlowRadius=startGlowRadius,
	              dx = 0f,
	              dy = 0f;

	private int glowColor = 0xFFffffff,    //ffffff defines hexadecimal value of color
			    glowSpeed;  
	
	private boolean isDirectionUp = true;  // Whether radius should increase or Decrease.
	
	private Handler handler;
	private Runnable r;
		
	public GlowingText(Activity mActivity,Context context,View v, float minRadius, float maxRadius, float startRadius, int color,int speed) {
		this.activity           =mActivity;
		this.mContext           = context;
		this.view               = v;
		this.minGlowRadius      = minRadius;
		this.maxGlowRadius      = maxRadius;
		this.startGlowRadius    = startRadius;
		this.glowColor          = color;
		this.glowSpeed          = speed;
	
		
		if(!(view instanceof TextView) && !(view instanceof Button)){
			Toast.makeText(context, view.getClass().getName()+" view does not support Glowy Text Animation.", Toast.LENGTH_SHORT).show();
			return;
		}else{
			if(startGlowRadius<minGlowRadius || startGlowRadius>maxGlowRadius){
				Random r = new Random();
				int start = r.nextInt((int)maxGlowRadius - (int)minGlowRadius + 1) + (int)minGlowRadius;
				startGlowRadius = start;
			}
			glowSpeed*=25;
			startGlowing();	
		}
	}

	private void startGlowing() {
		  handler = new Handler();
	         r =new Runnable(){
				public void run() {
					
				// Check Which View Is this
				if(view instanceof TextView){
					((TextView) view).setShadowLayer(currentGlowRadius, dx, dy,glowColor);
				}else if (view instanceof Button){
					((Button) view).setShadowLayer(currentGlowRadius, dx, dy,glowColor);
				}
				 
				/*	currentGlowRadius - 	Glow radius.
				 *  dx - 					Spread of Shadow in X direction
				 *  dy - 					Spread of Shadow in Y direction
				 *  color - 				Color used to create Glow (White in our case )
				 */
				
				if(isDirectionUp){
					/*	Increase Glow Radius by 1 */
					if(currentGlowRadius<maxGlowRadius){
						/*	Maximun has not reached. Carry On */
						currentGlowRadius++;
					}else{
						/*	Oops !! Max is reached. Stars decreasing glow radius now.
						 *  Change the Direction to Down.
					     */
						isDirectionUp = false;
					}
				}else{
					/*	Decrease Glow Radius by 1 */
					if(currentGlowRadius>minGlowRadius){
						/*	Minimum has not reached yet. Keep Decreasing */
						currentGlowRadius--;
					}else{
						/*	Oops !! Min is reached. Stars Increasing glow radius again.
						 *	Change the Direction to UP
					     */
						isDirectionUp = true;
					}
				}
					// Keep Looping
					handler.postDelayed(this, glowSpeed);	
				}
	        };
	        
	        // Starts Animation
	        handler.postDelayed(r, glowSpeed);      
	}
	
	public void setStartGlowRadius(final float startRadius){
		activity.runOnUiThread(new Runnable(){
			public void run() {
				startGlowRadius = startRadius;
			}
		});
	}
	
	public void setMaxGlowRadius(final float maxRadius){
		activity.runOnUiThread(new Runnable(){
			public void run() {
				maxGlowRadius =maxRadius;
			}
		});
	}
	
	public void setMinGlowRadius(final float minRadius){
		activity.runOnUiThread(new Runnable(){
			public void run() {
				minGlowRadius = minRadius;
			}
		});
	}
	
	public void setTransitionSpeed(final int speed){
		activity.runOnUiThread(new Runnable(){
			public void run() {
				glowSpeed = speed;
			}
		});
	}
	public void setGlowColor(final int color){
		activity.runOnUiThread(new Runnable(){
			public void run() {
				glowColor = color;
			}		
		});
	}
	
	public float getStartGlowRadius(){
		return this.startGlowRadius ;
	}
	
	public float getMaxGlowRadius(){
		return this.maxGlowRadius ;
	}
	
	public float getMinGlowRadius(){
		return this.minGlowRadius ;
	}
	
	public float getCurrentGlowRadius(){
		return this.currentGlowRadius ;
	}
	
	public int getTransitionSpeed(){
		return this.glowSpeed ;
	}
	
	public String getGlowColor(){
		return String.format("#%X", glowColor);
	}

	public void stopGlowing() {
		/* 	Destroy the Runnable r */
		handler.removeCallbacks(r);		
	}
	
	
	

}
