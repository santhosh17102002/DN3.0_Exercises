package exercise6;

import java.util.Scanner;

public class ImageViewer {
    interface Image {
        void display();
    }

    static class ProxyImage implements Image {
        private String filename;
        private RealImage realImage;

        public ProxyImage(String filename) {
            this.filename = filename;
        }

        @Override
        public void display() {
            if (realImage == null) {
                realImage = new RealImage(filename);
            }
            realImage.display();
        }

        private class RealImage implements Image {
            private String filename;

            public RealImage(String filename) {
                this.filename = filename;
                loadImageFromServer();
            }

            private void loadImageFromServer() {
                System.out.println("Loading image: " + filename);
                try {
                    Thread.sleep(2000); 
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void display() {
                System.out.println("Displaying image: " + filename);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Image image1 = new ProxyImage("image1.jpg");
        Image image2 = new ProxyImage("image2.jpg");

        System.out.println("Choose an option:");
        System.out.println("1. Display Image 1");
        System.out.println("2. Display Image 2");
        System.out.println("3. Exit");

        while (true) {
            System.out.println("Enter option : ");
            int choice = scanner.nextInt();
            if (choice == 3) {
                break;
            }

            switch (choice) {
                case 1:
                    image1.display();
                    break;
                case 2:
                    image2.display();
                    break;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }

        scanner.close();
    }
}
