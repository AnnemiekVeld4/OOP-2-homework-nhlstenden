package com.nhlstenden.week3;

public class DownloadNotAllowedException extends RuntimeException
{

    public DownloadNotAllowedException()
    {
        super();
    }

    public DownloadNotAllowedException(String message)
    {
        super(message);
    }
}
