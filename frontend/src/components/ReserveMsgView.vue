<template>

    <v-data-table
        :headers="headers"
        :items="reserveMsg"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'ReserveMsgView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "id", value: "id" },
            ],
            reserveMsg : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/reserveMsgs'))

            temp.data._embedded.reserveMsgs.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.reserveMsg = temp.data._embedded.reserveMsgs;
        },
        methods: {
        }
    }
</script>

