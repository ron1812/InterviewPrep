package com.practice.designpatterns.structural.facade;


/*
Use the Facade Pattern, when:
• You want to provide a simple interface to a complex subsystem. Subsystems often get more complex as they evolve. Most
patterns, when applied, result in more and smaller classes. This makes the subsystem more reusable and easier to customize,
but it also becomes harder to use for clients that don’t need to customize it. A facade can provide a simple default view of
the subsystem that is good enough for most clients. Only clients needing more customizability will need to look beyond the
facade.
• There are many dependencies between clients and the implementation classes of an abstraction. Introduce a facade to decouple
the subsystem from clients and other subsystems, thereby promoting subsystem independence and portability.
• You can layer your subsystems. Use a facade to define an entry point to each subsystem level. If subsystems are dependent,
then you can simplify the dependencies between them by making them communicate with each other solely through their
facades
 */
public class FacadeExample {

    public static void main(String[] args) {
        // Lets assume we asked the client to create instance of ScheduleServer
        // and in order to start or stop a server do multiple steps like below

        // ######################################################################################################
        // Issue in design is asking the client to call so many methods before system starts or stops

        ScheduleServer scheduleServer = new ScheduleServer();

        scheduleServer.startBooting();
        scheduleServer.readSystemConfigFile();
        scheduleServer.init();
        scheduleServer.initializeContext();
        scheduleServer.initializeListeners();
        scheduleServer.createSystemObjects();
        System.out.println("Start working......");
        System.out.println("After work done.........");

        // Steps to stop the server
        scheduleServer.releaseProcesses();
        scheduleServer.destory();
        scheduleServer.destroySystemObjects();
        scheduleServer.destoryListeners();
        scheduleServer.destoryContext();
        scheduleServer.shutdown();

        // Client is not happy with this approach and wants a simple way to start/stop server. In this case we need to use Facade pattern
        // ######################################################################################################

        // ##############################   SOLUTION   START  #######################################################
        // Solution is create a scheduledserverfacade class that does the main steps and client just need to call the start or stop server method

        ScheduleServerFacade facadeServer = new ScheduleServerFacade(scheduleServer);
        facadeServer.startServer();

        System.out.println("Start working......");
        System.out.println("After work done.........");

        facadeServer.stopServer();

        // ##############################   SOLUTION  END  #######################################################

    }
}
