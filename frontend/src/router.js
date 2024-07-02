
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import ReservationMsgReqManager from "./components/listers/ReservationMsgReqCards"
import ReservationMsgReqDetail from "./components/listers/ReservationMsgReqDetail"

import SenderMsgListManager from "./components/listers/SenderMsgListCards"
import SenderMsgListDetail from "./components/listers/SenderMsgListDetail"


import StatStatManager from "./components/listers/StatStatCards"
import StatStatDetail from "./components/listers/StatStatDetail"


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
                path: '/stats/stats',
                name: 'StatStatManager',
                component: StatStatManager
            },
            {
                path: '/stats/stats/:id',
                name: 'StatStatDetail',
                component: StatStatDetail
            },



    ]
})
