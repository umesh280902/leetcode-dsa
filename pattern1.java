import basic.output;

class Pattern1 {
    static class PatternBuilder {
        private Character star = '*'; // Default value
        private boolean useStar = false;
        private boolean starRowIndex = false;
        private boolean starColumnIndex = false;
        private boolean useRowIndex = false;
        private boolean useColumnIndex = false;
        private boolean counter = false;
        private boolean useFormula = false;
        private Integer count = 1;
        private Character starCounter = 'A';

        // Setters for optional parameters
        public PatternBuilder setStar(Character star) {
            this.star = star;
            return this;
        }

        public PatternBuilder setUseStar(boolean useStar) {
            this.useStar = useStar;
            return this;
        }

        public PatternBuilder setStarRowIndex(boolean starRowIndex) {
            this.starRowIndex = starRowIndex;
            return this;
        }

        public PatternBuilder setStarColumnIndex(boolean starColumnIndex) {
            this.starColumnIndex = starColumnIndex;
            return this;
        }

        public PatternBuilder setUseRowIndex(boolean useRowIndex) {
            this.useRowIndex = useRowIndex;
            return this;
        }

        public PatternBuilder setUseColumnIndex(boolean useColumnIndex) {
            this.useColumnIndex = useColumnIndex;
            return this;
        }

        public PatternBuilder setCounter(boolean counter) {
            this.counter = counter;
            return this;
        }

        public PatternBuilder setFormula(boolean useFormula) {
            this.useFormula = useFormula;
            return this;
        }

        private String getPattern(int i, int j) {
            if (useStar) {
                if (starRowIndex) {
                    return String.valueOf((char) (star + i - 1)); // Row-based alphabet
                } else if (starColumnIndex) {
                    return String.valueOf((char) (star + j - 1)); // Column-based alphabet
                } else if (useFormula) {
                    return String.valueOf((char) (starCounter + i + j - 2)); // Formula-based
                } else {
                    return String.valueOf(starCounter++); // Sequential characters
                }
            } else if (counter) {
                return String.valueOf(count++); // Sequential numbers
            } else if (useRowIndex) {
                return String.valueOf(i); // Row index
            } else if (useColumnIndex) {
                return String.valueOf(j); // Column index
            } else {
                return String.valueOf(star); // Default star
            }
        }

        public void build() {
            for (int i = 1; i <= 4; i++) {
                for (int j = 1; j <= 4; j++) {
                    output.print(getPattern(i, j) + " ");
                }
                output.print("\n");
            }
        }
    }

    public static void main(String[] args) {
        // Generate 8 distinct patterns
        output.print("Pattern 1: Default *\n");
        new PatternBuilder().setUseStar(false).build(); // Default star

        output.print("\nPattern 2: Row-based alphabet\n");
        new PatternBuilder().setStar('A').setUseStar(true).setStarRowIndex(true).build();

        output.print("\nPattern 3: Column-based alphabet\n");
        new PatternBuilder().setStar('A').setUseStar(true).setStarColumnIndex(true).build();

        output.print("\nPattern 4: Sequential alphabets\n");
        new PatternBuilder().setStar('A').setUseStar(true).build();

        output.print("\nPattern 5: Row index\n");
        new PatternBuilder().setUseRowIndex(true).build();

        output.print("\nPattern 6: Column index\n");
        new PatternBuilder().setUseColumnIndex(true).build();

        output.print("\nPattern 7: Sequential numbers\n");
        new PatternBuilder().setCounter(true).build();

        output.print("\nPattern 8: Formula-based alphabets\n");
        new PatternBuilder().setStar('A').setUseStar(true).setFormula(true).build();
    }
}
