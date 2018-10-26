# Doing OCR in Java

When I was getting a demo of Crimson Hexagon's image analysis data, Mitch, one of their product managers, was wishing that they were able to do Optical Character Recognition (OCR) on images. 

Memes are extremely popular and are often accompanied by written text. Also common is the sharing of screenshots of tweets or posts.

If we were able to do OCR on these memes, then we could make the text in the memes match users' queries.

# Installing Tesseract

[Tesseract](https://github.com/tesseract-ocr/tesseract) is an open source OCR library. You can use it with Java by using [Tess4J](http://tess4j.sourceforge.net/), however it's a bit of a pain to set up because it requires some command line tools and training data to be installed beforehand. 

Here's how (on my Mac). At the terminal:

```brew install tesseract --all-languages```

Then, once that's installed you need to download the training data and put it somewhere.

1. Go to [https://github.com/tesseract-ocr/tessdata](https://github.com/tesseract-ocr/tessdata)
2. Click "Clone or download" then "Download ZIP"
3. Unzip the folder somewhere on your machine.

Now you should be able to run the Java code.

# In Java

In my example you'll see that I've got the following variables: 

```tesseract.setDatapath("/Users/jamess/brandwatch/tessdata");
File directory = new File("/Users/jamess/Downloads");
```

The first statement should point to the training data folder you downloaded. The second should point to a folder you have images in to perform OCR on.

# Example outputs

[I've created a document with some results from some fairly arbitrary memes.](https://docs.google.com/document/d/1j5A-7HTP7wp3uNhLl8486Gd854XpzhXdBq1nOpaGlfY/edit)

Some observations:

* Regular screenshots of normal fonts work well (e.g. Twitter and Facebook screenshot)
* Image quality matters. The same font in poorer quality images worked worse.
* Some fonts don't work at all (e.g. the Simpsons/comic crossover)
* Tag a friend who has a knee
