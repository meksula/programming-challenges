package polygons.domain.shapes;

import javafx.scene.shape.Polygon;

/**
 * @Author
 * Karol Meksuła
 * 22-03-2018
 * */

public enum Shapes {
    EQUIVENTALTRIANGLE(8) {
        @Override
        public Polygon create() {
            return new EquivalentTriangle();
        }
    },
    SQUARE(10) {
        @Override
        public Polygon create() {
            return new Square();
        }
    },

    RECTANGLE(10) {
        @Override
        public Polygon create() {
            return new polygons.domain.shapes.Rectangle();
        }
    };

    public int doubles;

    Shapes(int doubles) {
        this.doubles = doubles;
    }

    public Polygon create() {
        return new Polygon();
    }

}
