package polygons.domain.shapes;

/**
 * @Author
 * Karol Meksuła
 * 22-03-2018
 * */

public enum Shapes {
    EQUIVENTALTRIANGLE {
        @Override
        public AvailableShapes createOne() {
            return new EquivalentTriangle();
        }
    },
    SQUARE {
        @Override
        public AvailableShapes createOne() {
            return new Square();
        }
    },

    RECTANGLE {
        @Override
        public AvailableShapes createOne() {
            return new Rectangle();
        }
    };

    public int doubles;

    public abstract AvailableShapes createOne();

}
