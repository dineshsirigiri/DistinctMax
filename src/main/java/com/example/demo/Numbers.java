package com.example.demo;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * Please add your description here.
 *
 * @author Pulse Innovations Ltd
 */
public class Numbers
{
    // 1, 4, 2, 2, 3
    private static LinkedList<Integer> addToLinkedList( LinkedList<Integer> linkedList, int item )
    {
        LinkedList<Integer> newLinkedList = new LinkedList<>();
        int tempItem = item;
        if ( linkedList.isEmpty() )
        {
            newLinkedList.add( tempItem );
        }
        else if ( linkedList.contains( tempItem ) )
        {
            return linkedList;
        }
        else
        {
            ListIterator<Integer> iterator = linkedList.listIterator();
            while ( iterator.hasNext() )
            {
                var nextItem = iterator.next();
                if ( nextItem < tempItem )
                {
                    newLinkedList.add( nextItem );
                }
                else if ( nextItem > tempItem )
                {
                    newLinkedList.add( tempItem );
                    tempItem = nextItem;
                }
            }

            newLinkedList.add( tempItem );
        }

        return newLinkedList;
    }

    public static int distinctMax( List<Integer> numbers, Integer maximumOf )
    {
        LinkedList<Integer> linkedList = new LinkedList<>();

        for ( Integer each : numbers )
        {
            linkedList = addToLinkedList( linkedList, each );
        }

        if ( maximumOf <= 0 )
        {
            System.out.println( "Invalid choice: " + maximumOf );
            return -1;
        }
        if ( linkedList.size() >= maximumOf )
        {
            return linkedList.get( linkedList.size() - maximumOf );
        }
        else
        {
            return linkedList.getLast();
        }

        /*int max = 0;

        List<Integer> numbersSet = numbers.stream().sorted().distinct().toList();

        if ( numbersSet.size() >= maximumOf && maximumOf > 0 )
        {
            max = numbersSet.get( numbersSet.size() - maximumOf );
        }
        else if ( maximumOf > 0 )
        {
            max = numbersSet.get( numbersSet.size() - 1 );
        } else {
            max = -1;
        }

        return max;*/
    }

    public static void main( String[] args )
    {
        System.out.println( distinctMax( List.of( 1, 4, 2, 2, 3 ), 5 ) );
    }
}
