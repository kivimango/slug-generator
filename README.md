# slug-generator
Generate a random, unique string from letters and numbers in 9gag-style which you can use for  identify a blog post,
a video, an article etc. in an URL.
[![License: GPL v3](https://img.shields.io/badge/License-GPL%20v3-blue.svg)](http://www.gnu.org/licenses/gpl-3.0)
[![Build Status](https://travis-ci.org/kivimango/slug-generator.svg?branch=master)](https://travis-ci.org/kivimango/slug-generator)

## Usage
 Create a new instance of the SlugGenerator class.
`SlugGenerator generator = new SlugGenerator();`

 Call the **generate()** method with the following parameters :
 
1. (byte) The generation modifier flag.Possible values is the pre-defined constants of the SlugGenerator class :
*GENERATE_ONLY_FROM_NUMBERS*,
*GENERATE_ONLY_FROM_LETTERS*, 
and *GENERATE_FROM_NUMBERS_AND_LETTERS*.
The default is *GENERATE_FROM_NUMBERS_AND_LETTERS*.

2. (int) The final character length of the generated slug.

3. For example, 
`generate(SlugGenerator.GENERATE_ONLY_FROM_NUMBERS, 23)` will produce a 23 character long String containing only numbers.

### More info
* The result's character length is limited to minimum 3, and maximum 127 character long.
* The *GENERATE_FROM_NUMBERS_AND_LETTERS* option does not guarantee that the result will contain both numbers AND letters.
* The *GENERATE_ONLY_FROM_LETTERS*, and *GENERATE_FROM_NUMBERS_AND_LETTERS* will contain letters from the english alphabet only.
* If you pass unallowed parameters to the generate() method, the class will generate the result with the default parameters
(e.g. will be 3 character long and the option will be GENERATE_FROM_NUMBERS_AND_LETTERS).If the length is bigger than 
the maximum length limit, the class will silently cut to the maximum limit.

### Reporting bugs
Please use the github [Issue Tracker](https://github.com/kivimango/slug-generator/issues) to report errors, bugs, 
unexpected behaviors of the program.You can also use the Issues to send feature requests, improvements.