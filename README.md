# Gradient RecyclerView 
[![Build Status](https://travis-ci.org/krunal3kapadiya/Gradient-RecyclerView.svg?branch=master)](https://travis-ci.org/krunal3kapadiya/Gradient-RecyclerView)

Displaying gradients in each rows of RecyclerView

## How to use? :thinking:	
Use [ValueInterpolator](app/src/main/java/krunal3kapadiya/com/gradientrecyclerview/data/ValueInterpolator.java) class and add this method

```
    public int[] getGradientColors(int startColor, int endColor, int size) {
        int colors[] = new int[size];

        int startR = Color.red(startColor);
        int startG = Color.green(startColor);
        int startB = Color.blue(startColor);

        int endR = Color.red(endColor);
        int endG = Color.green(endColor);
        int endB = Color.blue(endColor);

        ValueInterpolator interpolatorR = new ValueInterpolator(0, size - 1, endR, startR);
        ValueInterpolator interpolatorG = new ValueInterpolator(0, size - 1, endG, startG);
        ValueInterpolator interpolatorB = new ValueInterpolator(0, size - 1, endB, startB);

        for (int i = 0; i < size; ++i) {
            colors[i] = Color.argb(255, (int) interpolatorR.map(i), (int) interpolatorG.map(i), (int) interpolatorB.map(i));
        }
        return colors;
    }
```

## Screenshot
<img src="/screenshot.png" width="350"/>

## How to contribute?
- Check out contribution :point_right: [Guidelines](./CONTRIBUTING.md)  

## Questions

Tweet me at: 
[![Twitter URL](https://img.shields.io/badge/Twitter-@krunal3kapadiya-blue.svg?style=for-the-badge)](https://twitter.com/krunal3kapadiya)

## Licence
    Copyright 2018 Krunal Kapadiya

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
