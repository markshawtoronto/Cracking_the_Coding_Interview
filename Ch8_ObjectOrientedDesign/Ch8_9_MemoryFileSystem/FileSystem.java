package com.CrackingTheCodingInterview.Ch8_ObjectOrientedDesign.Ch8_9_MemoryFileSystem;

import java.util.*;

public class FileSystem
{
    public abstract class Item
    {
        String name;
        Folder parent;
        long created;
        long lastUpdated;
        long lastAccessed;

        public Item(String name, Folder parent)
        {
            this.parent = parent;
            parent.contains.add(this);
            this.name = name;
            this.created = System.currentTimeMillis();
            this.lastAccessed = System.currentTimeMillis();
            this.lastUpdated = System.currentTimeMillis();
        }

        public boolean delete()
        {
            if (this.parent == null)
            {
                return false;
            }
            else
            {
                return parent.deleteEntry(this);
            }
        }
    }

    public class File extends Item
    {
        public File(String name, Folder parent, FileExtension extension)
        {
            super(name, parent);
            this.extension = extension;
        }
        FileExtension extension;
        int size; // In bytes
    }

    public class Folder extends Item
    {
        public Folder(String name, Folder parent)
        {
            super(name, parent);
        }

        ArrayList<Item> contains;

        public boolean deleteEntry(Item item)
        {
            contains.remove(item);
            return true;
        }
    }

    public enum FileExtension
    {
        jpg, png, mp3
    }
}
