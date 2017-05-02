package com.kivimango.sluggenerator;

import java.util.Random;

/**
 *   _________.__                 ________                                   __
 *  /   _____/|  |  __ __  ____  /  _____/  ____   ____   ________________ _/  |_  ___________
 *  \_____  \ |  | |  |  \/ ___\/   \  ____/ __ \ /    \_/ __ \_  __ \__  \\   __\/  _ \_  __ \
 *  /        \|  |_|  |  / /_/  >    \_\  \  ___/|   |  \  ___/|  | \// __ \|  | (  <_> )  | \/
 * /_______  /|____/____/\___  / \______  /\___  >___|  /\___  >__|  (____  /__|  \____/|__|
 *         \/           /_____/         \/     \/     \/     \/           \/
 *
 *  This class will generate a random, unique string from letters and numbers in 9gag-style which you can use for
 *  identify a blogpost, a video, an article etc. in an URL.
 *
 *  @author     kivimango
 *  @link       https://github.com/kivimango/slug-generator/
 *  @version    0.1
 */

public class SlugGenerator {

    /**
     * Generation options.
     * FYI: the slug will contain letters from the english alphabet only.
     */

    public static final byte GENERATE_ONLY_FROM_NUMBERS = 0;
    public static final byte GENERATE_ONLY_FROM_LETTERS = 1;
    public static final byte GENERATE_FROM_NUMBERS_AND_LETTERS = 2;

    private final byte LENGTH_LIMIT = 127;

    private char[] numbers = "0123456789".toCharArray();
    private char[] letters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    private char[] numbersAndLetters = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

    /**
     * Randomizing the slug based on the generation option and length.
     * The maximum length of the slug limited to 127 character, it should cover all the needs of the user/client
     * (if the passed length parameter is bigger than the limit, the class will silently cut the value to the limit).
     *
     * @author       kivimango
     * @version      1.0
     * @since        1.0
     * @param option The generation modifier flag.Possible values is GENERATE_ONLY_FROM_NUMBERS,
     *               GENERATE_ONLY_FROM_LETTERS, and GENERATE_FROM_NUMBERS_AND_LETTERS.
     *               The default is GENERATE_FROM_NUMBERS_AND_LETTERS.
     * @param length The final character length of the generated slug.
     * @return The generated slug based on the passed parameters.
     *
     */

    public String generate(byte option, int length) {
        char[] slug = new char[length];

        if(length>LENGTH_LIMIT) {
            length = LENGTH_LIMIT;
        }

        switch(option) {
            case GENERATE_ONLY_FROM_NUMBERS :
                slug = generateFromSource(numbers, length);
                break;
            case GENERATE_ONLY_FROM_LETTERS :
                slug = generateFromSource(letters, length);
                break;
            case GENERATE_FROM_NUMBERS_AND_LETTERS :
                slug = generateFromSource(numbersAndLetters, length);
                break;
            default :
                slug = generateFromSource(numbersAndLetters, length);
                break;
        }
        return String.valueOf(slug);
    }

    /**
     * Method to avoid code duplication.
     * The generation will happen here.
     *
     * @author       kivimango
     * @version      1.0
     * @since        1.0
     */

    private char[] generateFromSource(char[] source, int length) {
        char[] result = new char[length];
        Random randomizer = new Random();

        for(byte i=0; i<length; i++) {
            result[i] = source[randomizer.nextInt(source.length)];
        }
        return result;
    }
}