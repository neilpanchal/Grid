import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import com.chroma.*; 
import com.luma.*; 
import java.util.UUID; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Build extends PApplet {

// Author: Neil Panchal
// License: The MIT License
// Copyright (c) 2015 Neil Panchal, http://neil.engineer
// ----------------------------------------------------------------------------

// Import libraries




// Project details
String project_name = "Boiler Plate";
String project_color = "Color";
String folder_name = "Series 1";
String file_title = "boiler_plate";

int frame = 1;

// Canvas
int CANVASX = 1280;
int CANVASY = 720;

boolean bgWhite = false;

// Color palette
int lumaNumber = 18, lumaQuality = 60;
int lumaMinL = 15, lumaMaxL = 25;
int lumaMinC = 15, lumaMaxC = 55;
int lumaMinH = 170, lumaMaxH = 360;

Luma lumaColors = new Luma( lumaNumber, lumaQuality,
                            lumaMinL, lumaMaxL,
                            lumaMinC, lumaMaxC,
                            lumaMinH, lumaMaxH);

Chroma[] palette = lumaColors.getClusters();


// ----------------------------------------------------------------------------
public void setup() {

    size(CANVASX, CANVASY, "processing.core.PGraphicsRetina2D");
    background(getRandomColor().get());
    frameRate(30);
    smooth();

}

public void draw() {
    delay(1000);
    background(getRandomColor().get());
}


// ----------------------------------------------------------------------------
public void mousePressed() {

    background(getRandomColor().get());
}

public void keyReleased() {
    // Save a screenshot in PNG format
    if (key == 's' || key == 'S') {
        saveFrame("../Export/" + project_name + "/" + project_color + "/" + folder_name + "/"
                  + file_title + "_" + frame + "_" + UUID.randomUUID().toString().substring(0, 8) +  ".png");
                    frame++;
    }
}

// Get a random palette color
public Chroma getRandomColor() {
    return (bgWhite) ? new Chroma(255) : palette[(int)random(0, palette.length)];
}

public void delay(int delay) {
    int time = millis();
    while (millis() - time <= delay);
}
public class Grid {

    private int xWidth;
    private int yWidth;

    private int xPadding;
    private int yPadding;

    private int xDensity;
    private int yDensity;

    private int xSpacing;
    private int ySpacing;

    public Grid(int xWidth_, int yWidth_, int xDensity_, int yDensity_, int xPadding_, int yPadding_) {

        this.xWidth = xWidth_;
        this.yWidth = yWidth_;

        this.xDensity = xDensity_;
        this.yDensity = yDensity_;

        this.xPadding = xPadding_;
        this.yPadding = yPadding_;

        this.xSpacing = (xWidth_ - (2 * xPadding_)) / xDensity_;
        this.ySpacing = (yWidth_ - (2 * yPadding_)) / yDensity_;
    }

    public Grid(int xWidth_, int yWidth_, int xDensity_, int yDensity_) {

        this(xWidth_, yWidth_, xDensity_, yDensity_, xWidth_ / xDensity_, yWidth_ / yDensity_);
    }


}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Build" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
