/**
 * Project: Space Game - Caesar Cipher, HMAC/SHA256 Hash
 * Purpose Details: GameObject Class Define for sender
 * Course: IST 242
 * Author: Abdullah Koro
 * Date Developed: 6/3/24
 * Last Date Changed: 6/16/24
 * Revision: 2
 */

/**
 * Represents GameObject Class
 */
public class GameObject

{
    private String name;
    private int score;

    public GameObject()
    {
        // Default constructor needed for JSON serialization
    }

    public GameObject(String name, int score)
    {
        this.name = name;
        this.score = score;
    }

    // Getters and setters
    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getScore()
    {
        return score;
    }

    public void setScore(int score)
    {
        this.score = score;
    }

    @Override
    public String toString()
    {
        return "GameObject{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}
