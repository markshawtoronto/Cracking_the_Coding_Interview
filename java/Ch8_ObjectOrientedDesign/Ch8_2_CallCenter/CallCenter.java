package com.CrackingTheCodingInterview.Ch8_ObjectOrientedDesign.Ch8_2_CallCenter;

import java.util.*;

// 8.2 - Implement a call center with three levels of employees (respondent, manager, director)
// An incoming phone call must be allocated to a respondent who is free.
// dispatch_call() should allocate to the first available respondent, then a manager if they're all busy, then the director.
public class CallCenter
{
    private static CallCenter instance;

    // Queues for each call
    List<Queue<Call>> call_queues;

    // List of each employee
    List<List<Employee>> employee_list;

    // Assign a call to the first available employee
    public void dispatch_call(Caller caller)
    {
        Call call = new Call(caller);

        dispatch_call(call);
    }

    public void dispatch_call(Call call)
    {
        // Attempt adding the caller to the Queue<> if no employee is available to take the call.
        Employee e = get_call_handler(call);
        if (e != null)
        {
            e.receive_call(call);
            call.set_handler(e);
        }
        else
        {
            // Place the call into the appropriate call queue.
            call_queues.get(call.getRank().getValue()).add(call);
        }
    }

    public Employee get_call_handler(Call call)
    {
        // Get first available employee who can handle this call.
        if (call.rank.equals(Rank.Operator))
        {
            for (Employee e : employee_list.get(0)) // (O(n) to find free employee)
            {
                if (e.is_free())
                {
                    return e;
                }
            }
        }

        return null;
    }

    abstract class Employee
    {
        private Call current_call = null;
        protected Rank rank;

        public void receive_call(Call c)
        {
            if (current_call == null)
            {
                current_call = c;
            }
        }

        public void call_completed()
        {
            current_call.complete = true;
            current_call = null;
        }

        public void escalate_and_reassign()
        {

        }

        public boolean is_free()
        {
            if (this.current_call == null)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
    }

    class Respondent extends Employee
    {
        public Respondent()
        {
            rank = Rank.Operator;
        }
    }

    class Manager extends Employee
    {
        public Manager()
        {
            rank = Rank.Manager;
        }
    }

    class Director extends Employee
    {
        public Director()
        {
            rank = Rank.Director;
        }
    }

    class Call
    {
        Caller caller; // Person who is calling
        Rank rank; // Desired rank of caller (manager, etc)
        Employee handler = null; // Employee who is handling the call
        boolean complete = false;
        public Call(Caller c)
        {
            this.caller = c;
        }

        public void set_handler(Employee e)
        {
            this.handler = e;
        }

        public Rank getRank()
        {
            return this.rank;
        }
    }

    public enum Rank
    {
        Operator (0), Manager (1), Director (2);
        private int value;

        private Rank(int v)
        {
            this.value = v;
        }
        public int getValue()
        {
            return value;
        }
    }

    class Caller
    {
        Integer id;
        String first_name;
        String last_name;
    }
}