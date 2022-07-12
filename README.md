# slug-generator
[![License: GPL v3](https://img.shields.io/badge/License-GPL%20v3-blue.svg)](http://www.gnu.org/licenses/gpl-3.0)
[![Build Status](https://travis-ci.org/kivimango/slug-generator.svg?branch=master)](https://travis-ci.org/kivimango/slug-generator)
[![Coverity Scan Build Status](https://scan.coverity.com/projects/13108/badge.svg)](scan.coverity.com/projects/kivimango-slug-generator)
[![CodeCov coverage](https://codecov.io/gh/kivimango/slug-generator/branch/master/graph/badge.svg)](https://codecov.io/gh/kivimango/slug-generator)

Generate a random, unique string from letters and numbers in 9gag-style which you can use for  identify a blog post,
a video, an article etc. in an URL.

## Usage
Call the static method **generate()** of the class with the following parameters
1. (Options enum) The generation modifier flag.Choose from the Options enum :
    *GENERATE_ONLY_FROM_NUMBERS*,
    *GENERATE_ONLY_FROM_LETTERS*, 
    and *GENERATE_FROM_NUMBERS_AND_LETTERS*.
    The default is *GENERATE_FROM_NUMBERS_AND_LETTERS*.
2. (int) The final character length of the generated slug.
    
3. For example, 
 `SlugGenerator.generate(SlugGenerator.Options.GENERATE_FROM_NUMBERS, 23);` 
 will produce a 23 character long String containing only numbers.

### More info
* The result's character length is limited to minimum 3, and maximum 127 character long.
* The *GENERATE_FROM_NUMBERS_AND_LETTERS* option does not guarantee that the result will contain both numbers AND letters.
* The *GENERATE_ONLY_FROM_LETTERS*, and *GENERATE_FROM_NUMBERS_AND_LETTERS* will contain letters from the english alphabet only.
* If the length is bigger than the maximum length limit, the class will silently cut to the maximum limit.

### Reporting bugs
Please use the GitHub [Issue Tracker](https://github.com/kivimango/slug-generator/issues) to report errors, bugs, 
unexpected behaviors of the program.You can also use the Issues to send feature requests, improvements.