
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import ReservationMsgReqManager from "./components/listers/ReservationMsgReqCards"
import ReservationMsgReqDetail from "./components/listers/ReservationMsgReqDetail"

import SenderMsgListManager from "./components/listers/SenderMsgListCards"
import SenderMsgListDetail from "./components/listers/SenderMsgListDetail"


import BoundedContext1410StatManager from "./components/listers/BoundedContext1410StatCards"
import BoundedContext1410StatDetail from "./components/listers/BoundedContext1410StatDetail"


export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/reservations/msgReqs',
                name: 'ReservationMsgReqManager',
                component: ReservationMsgReqManager
            },
            {
                path: '/reservations/msgReqs/:id',
                name: 'ReservationMsgReqDetail',
                component: ReservationMsgReqDetail
            },

            {
                path: '/senders/msgLists',
                name: 'SenderMsgListManager',
                component: SenderMsgListManager
            },
            {
                path: '/senders/msgLists/:id',
                name: 'SenderMsgListDetail',
                component: SenderMsgListDetail
            },


            {
                path: '/boundedContext1410s/stats',
                name: 'BoundedContext1410StatManager',
                component: BoundedContext1410StatManager
            },
            {
                path: '/boundedContext1410s/stats/:id',
                name: 'BoundedContext1410StatDetail',
                component: BoundedContext1410StatDetail
            },



    ]
})
