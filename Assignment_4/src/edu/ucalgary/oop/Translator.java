package edu.ucalgary.oop;

import java.io.*;
import java.util.*;
import java.util.regex.Pattern;

public class Translator{

    private TranslationText translation;
    private String regionCode;


    /* getTranslation()
     * getter method returning a stored TranslationText object.
     */

    public TranslationText getTranslation(){
        return this.translation;
    }

    /* translate()
     * Accepts a month number (e.g., 1 for January), a day number (e.g., 31 for
     * the 31st), and a year. Note that years may be any previous year in the common era
     * (CE) from 0 to the previous year, or they may be before the common era (BCE),
     * represented by negative numbers. Thus 2021, 800, and -1600 are all valid years.
     * Method throws an IllegalArgumentException if monthNum or dayNum is not
     * valid. Returns the formatted sentence as a String. Notice that the String
     * containing formatting uses numbered arguments - this is because some languages
     * will put the words in the sentence in a different order, but the translate()
     * method must be able to work without knowledge of the language structure.
     * Note: You do not have to check if a day is valid for a particular month/year;
     * February 31 or February 29, 2021 can both be accepted, but out of range values
     * e.g., month 15 day 0, are not valid and should be handled with an
     * IllegalArgumentException.
     *
     * this returns the sentence from the translation text with the formatted values
     */

    public String translate(int monthNum, int dayNum, int year) throws IllegalArgumentException {
        if (monthNum < 1 || monthNum > 12) {
            throw new IllegalArgumentException("Invalid month number");
        }
        if (dayNum < 1 || dayNum > 31) {
            throw new IllegalArgumentException("Invalid day number");
        }

        String month = this.translation.getMonth(monthNum-1);
        String day = this.translation.getDay(dayNum - 1);
        String sentence = this.translation.getSentence();

        String formattedSentence = String.format(sentence, day, month, year);

        return formattedSentence;
    }


    /* Constructor
     * Accepts a String of a two-letter language code (lowercase), dash, and two-letter
     * region (caps) code, e.g., te-IN and throws an IllegalArgumentException if the language
     * and region code are not in the correct format. Language codes are ISO 639-1 and
     * region codes are ISO 3166, but this method only checks the format of the String,
     * not if the region and language codes are valid according to the ISO specifications.
     * The input parameter must exactly match the expected format.
     * It calls importTranslation().
     * Does not catch ArgFileNotFoundException (exception may optionally be caught
     * by code which invokes this constructor).
     */

    public Translator(String langRegionCode) throws IllegalArgumentException, ArgFileNotFoundException {
        if (!Pattern.matches("[a-z]{2}-[A-Z]{2}", langRegionCode)) {
            throw new IllegalArgumentException("Invalid language code format");
        }
        this.regionCode = langRegionCode;
        try {
            importTranslation();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        // to get around this^, maybe have the constructor create a local varible that stores the
        // landRegionCode, so that it can be used in deserilize() or importTranslation
    }

    /* importTranslation()
     * Calls deserialize() if the appropriate file exists, otherwise calls importFromText().
     * No arguments. Returns void.
     */

    private void importTranslation() throws ArgFileNotFoundException, IOException, ClassNotFoundException {
        String filename = this.regionCode + ".ser";
        File file = new File(filename);
        if (file.exists()) {
            deserialize();
        } else {
             importFromText();
        }
    }

    /* importFromText()
     * Reads in from a the two-letter language code, dash, two-letter region code text
     * file, in the form of ab-XY.txt, and instantiates a TranslationText object with
     * the data. It can throw I/O exceptions. Throw a custom ArgFileNotFoundException
     * when the file isn't found.
     * We expect the .txt file to be in a valid format. The file is expected to be in the same
     * directory. The files en-US.txt and el-GR.txt are examples of a valid .txt files. They will
     * always consist of the month names, one per line, followed by the day names, one per line,
     * followed by the sentence containing formatting strings. This is the last line in the file. You
     * cannot make any assumptions about what will appear on each line, only that each line
     * will contain only one data element, and that it will not contain an empty line.
     * No arguments. Returns void.
     */

    private void importFromText() throws ArgFileNotFoundException {
        String filename = this.regionCode + ".txt";
        File file = new File(filename);
        if (!file.exists()) {
            throw new ArgFileNotFoundException();
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line = reader.readLine();
            int i = 0;
            String[] months = new String[12];
            while (line != null && i < 12) {
                months[i] = line.trim();
                line = reader.readLine();
                i++;
            }

            i = 0;
            String[] days = new String[31];
            while (line != null && i < 31) {
                days[i] = line.trim();
                line = reader.readLine();
                i++;
            }

            StringBuilder sentence = new StringBuilder();
            while (line != null) {
                sentence.append(line.trim());
                line = reader.readLine();
            }

            this.translation = new TranslationText(months, days, sentence.toString());
        } catch (IOException e) {
            throw new ArgFileNotFoundException();
        }
    }

    /* serialize()
     * Creates a serialized object file of the TranslationText object, with the
     * name format la-CO.ser, where la is the two-letter language code and CO is
     * the two-letter region code. An example of a serialized object file can be
     * found in the exercise directory as es-BO.ser
     * I/O exceptions can be thrown.
     * No arguments. Returns void.
     */

    public void serialize() throws IOException {
        String filename = this.regionCode + ".ser";
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
            out.writeObject(translation);
        }
    }

    /* deserialize()
     * Creates a TranslationText object from a .ser file. The files are named
     * xx-YY.ser, where xx is the two-letter language code and YY is the two-
     * letter region code. es-BO.ser is an example. It can throw I/O exceptions.
     * No arguments. Returns void.
     */

    private void deserialize() throws IOException, ClassNotFoundException {
        String filename = this.regionCode + ".ser";

        try (var in = new ObjectInputStream(new FileInputStream(filename))) {
            translation = (TranslationText) in.readObject();
        }

    }


}

