package com.example.service

import akka.actor.Actor
import spray.routing._
import spray.http._
import MediaTypes._

/**
  * Created by root on 2016/01/26.
  */
class CustomerServiceActor extends Actor with CustomerService {
  def receive = runRoute(customerRoutes)

  override implicit def actorRefFactory = context
}

trait CustomerService extends HttpService{
  val customerRoutes =
    path("addCustomer"){
      post{
        complete{
          "Success"
        }
      }
    }~
    path("getCustomer" / Segment) { customerId =>
      get {
        complete {
          s"success ${customerId}"
        }
      }
    }
}
