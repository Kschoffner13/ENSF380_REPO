package edu.ucalgary.oop;

import java.io.*;
import java.util.regex.Pattern;

public class translatortest {
    public class Translator implements Serializable {
        private static final long serialVersionUID = 19L;
        private TranslationText translationText;

        public Translator(String langRegionCode) throws IllegalArgumentException, ArgFileNotFoundException {
            if (!Pattern.matches("[a-z]{2}-[A-Z]{2}", langRegionCode)) {
                throw new IllegalArgumentException("Invalid language code format");
            }
            importTranslation(langRegionCode);
        }

        public TranslationText getTranslation() {
            return translationText;
        }

        public String translate(int monthNum, int dayNum, int year) throws IllegalArgumentException {
            if (monthNum < 1 || monthNum > 12) {
                throw new IllegalArgumentException("Invalid month number");
            }
            if (dayNum < 1 || dayNum > 31) {
                throw new IllegalArgumentException("Invalid day number");
            }

            String[] months = translationText.getMonths();
            String[] days = translationText.getDays();
            String sentence = translationText.getSentence();

            String formattedSentence = String.format(sentence, months[monthNum - 1], days[dayNum - 1], year);

            return formattedSentence;
        }

        private void importTranslation(String langRegionCode) throws ArgFileNotFoundException {
            String filename = langRegionCode + ".txt";
            File file = new File(filename);
            if (file.exists()) {
                deserialize(langRegionCode);
            } else {
                importFromText(langRegionCode);
            }
        }

        private void importFromText(String langRegionCode) throws ArgFileNotFoundException {
            String filename = langRegionCode + ".txt";
            File file = new File(filename);
            if (!file.exists()) {
                throw new ArgFileNotFoundException("File not found");
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

                translationText = new TranslationText(months, days, sentence.toString());
                serialize(langRegionCode);
            } catch (IOException e) {
                throw new ArgFileNotFoundException("File not found");
            }
        }

        private void serialize(String langRegionCode) throws IOException {
            String filename = langRegionCode + ".ser";
            try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
                out.writeObject(translationText);
            }
        }

        private void deserialize(String langRegionCode) throws ArgFileNotFoundException {
            String filename = langRegionCode + ".ser";
            File file = new File(filename);
            if (!file.exists()) {
                throw new ArgFileNotFoundException("File not found");
            }

            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
                translationText = (TranslationText) in.readObject();
            } catch (IOException | ClassNotFoundException e) {
                throw new ArgFileNotFoundException("File not found");
            }
        }
    }
}
