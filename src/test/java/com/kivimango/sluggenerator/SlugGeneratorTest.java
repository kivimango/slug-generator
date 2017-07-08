package com.kivimango.sluggenerator;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Since the generated results are randomized, we cant really test out, except the generation options.
 *
 * @author  kivimango
 * @version 1.1
 * @since   1.0
 */

public class SlugGeneratorTest {

    @Test
    public void TestSlugLength() {
        int desiredLength = 7;
        String slugForBlogPost = SlugGenerator.generate(SlugGenerator.Options.GENERATE_FROM_NUMBERS_AND_LETTERS, desiredLength);
        assertEquals(slugForBlogPost.length(), desiredLength);
    }

    @Test
    public void SlugLengthShouldBeCutToMinimumLimit() {
        int tooShortLength = 0;
        String slugForPicture = SlugGenerator.generate(SlugGenerator.Options.GENERATE_FROM_NUMBERS_AND_LETTERS, tooShortLength);
        assertEquals(slugForPicture.length(), SlugGenerator.LENGTH_MIN_LIMIT);
    }

    @Test
    public void SlugLengthShouldBeCutToMaximumLimit() {
        int tooLongLength = 4653;
        String slugForPicture = SlugGenerator.generate(SlugGenerator.Options.GENERATE_FROM_NUMBERS_AND_LETTERS, tooLongLength);
        assertEquals(slugForPicture.length(), SlugGenerator.LENGTH_MAX_LIMIT);
    }

    @Test
    public void SlugShouldContainOnlyNumbers() {
        int desiredLength = 10;
        String nineGagPostSlug = SlugGenerator.generate(SlugGenerator.Options.GENERATE_ONLY_FROM_NUMBERS, desiredLength);
        assertEquals(desiredLength, nineGagPostSlug.length());
        assertEquals(true, nineGagPostSlug.matches("[0-9]+"));
    }

    @Test
    public void SlugShouldContainOnlyLetters() {
        int desiredLength = 12;
        String articleSlug = SlugGenerator.generate(SlugGenerator.Options.GENERATE_ONLY_FROM_LETTERS, desiredLength);
        assertEquals(desiredLength, articleSlug.length());
        assertEquals(true, articleSlug.matches("[a-zA-Z]+"));
    }

    @Test
    public void SlugShouldContainNumbersOrLetters() {
        int desiredLength = 23;
        String webShopProductSlug = SlugGenerator.generate(SlugGenerator.Options.GENERATE_FROM_NUMBERS_AND_LETTERS, desiredLength);
        assertEquals(desiredLength, webShopProductSlug.length());
        assertEquals(true, webShopProductSlug.matches("^[0-9a-zA-Z]*$"));
    }
}