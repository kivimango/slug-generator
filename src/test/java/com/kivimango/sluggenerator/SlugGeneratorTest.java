package com.kivimango.sluggenerator;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Since the generated results are randomized, we cant really test out, except the generation options.
 *
 * @author  kivimango
 * @version 1.0
 * @since   1.0
 */

public class SlugGeneratorTest {

    private SlugGenerator slugGenerator = new SlugGenerator();

    @Test
    void TestSlugLength() {
        int desiredLength = 7;
        String slugForBlogPost = slugGenerator.generate(SlugGenerator.GENERATE_FROM_NUMBERS_AND_LETTERS, desiredLength);
        assertEquals(slugForBlogPost.length(), desiredLength);
    }

    @Test
    void SlugLengthShouldBeCuttedToLimit() {
        int tooLongLength = 4653;
        String slugForPicture = slugGenerator.generate(SlugGenerator.GENERATE_FROM_NUMBERS_AND_LETTERS, tooLongLength);
        assertEquals(slugForPicture.length(), SlugGenerator.LENGTH_LIMIT);
    }

    @Test
    void SlugShouldContainOnlyNumbers() {
        int desiredLength = 10;
        String nineGagPostSlug = slugGenerator.generate(SlugGenerator.GENERATE_ONLY_FROM_NUMBERS, desiredLength);
        assertEquals(true, nineGagPostSlug.matches("[0-9]+"));
    }

    @Test
    void SlugShouldContainOnlyLetters() {
        int desiredLength = 12;
        String articleSlug = slugGenerator.generate(SlugGenerator.GENERATE_ONLY_FROM_LETTERS, desiredLength);
        assertEquals(true, articleSlug.matches("[a-zA-Z]+"));
    }

    @Test
    void SlugShouldContainNumbersOrLetters() {
        int desiredLength = 23;
        String webShopProductSlug = slugGenerator.generate(SlugGenerator.GENERATE_FROM_NUMBERS_AND_LETTERS, desiredLength);
        assertEquals(true, webShopProductSlug.matches("[0-9a-zA-Z]+"));
    }
}