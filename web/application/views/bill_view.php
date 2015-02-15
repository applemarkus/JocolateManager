<?php
defined('BASEPATH') OR exit('No direct script access allowed');
?>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <style>
            article,aside,details,figcaption,figure,footer,header,hgroup,main,nav,section,summary
            {
                display: block;
            }
            [hidden]
            {
                display: none;
            }
            html
            {
                font-size: 100%;
                ms-text-size-adjust: 100%;
                webkit-text-size-adjust: 100%;
            }
            html,button,input,select,textarea
            {
                font-family: sans-serif;
            }
            body
            {
                margin: 0;
                padding-left: 20px;
            }
            a:focus
            {
                outline: thin dotted;
            }
            a:active,a:hover
            {
                outline: 0;
            }
            h1
            {
                font-size: 2em;
                margin: .67em 0;
            }
            h2
            {
                font-size: 1.5em;
                margin: .83em 0;
            }
            h3
            {
                font-size: 1.17em;
                margin: 1em 0;
            }
            h4
            {
                font-size: 1em;
                margin: 1.33em 0;
            }
            h5
            {
                font-size: .83em;
                margin: 1.67em 0;
            }
            h6
            {
                font-size: .67em;
                margin: 2.33em 0;
            }
            abbr[title]
            {
                border-bottom: 1px dotted;
            }
            b,strong
            {
                font-weight: 700;
            }
            blockquote
            {
                margin: 1em 40px;
            }
            dfn
            {
                font-style: italic;
            }
            hr
            {
                box-sizing: content-box;
                height: 0;
                moz-box-sizing: content-box;
            }
            mark
            {
                background: #ff0;
                color: #000;
            }
            p,pre
            {
                margin: 1em 0;
            }
            code,kbd,pre,samp
            {
                _font-family: 'courier new',monospace;
                font-family: monospace,serif;
                font-size: 1em;
            }
            pre
            {
                white-space: pre;
                white-space: pre-wrap;
                word-wrap: break-word;
            }
            q
            {
                quotes: none;
            }
            q:before,q:after
            {
                content: '';
                content: none;
            }
            small
            {
                font-size: 80%;
            }
            sub,sup
            {
                font-size: 75%;
                line-height: 0;
                position: relative;
                vertical-align: baseline;
            }
            sup
            {
                top: -.5em;
            }
            sub
            {
                bottom: -.25em;
            }
            dl,menu,ol,ul
            {
                margin: 1em 0;
            }
            dd
            {
                margin: 0 0 0 40px;
            }
            menu,ol,ul
            {
                padding: 0 0 0 40px;
            }
            nav ul,nav ol
            {
                list-style: none;
                list-style-image: none;
            }
            img
            {
                border: 0;
                ms-interpolation-mode: bicubic;
            }
            svg:not(:root)
            {
                overflow: hidden;
            }
            figure
            {
                margin: 0;
            }
            form
            {
                margin: 0;
            }
            fieldset
            {
                border: 1px solid silver;
                margin: 0 2px;
                padding: .35em .625em .75em;
            }
            table
            {
                border-collapse: collapse;
                border-spacing: 0;
            }
            [hidden]
            {
                display: none!important;
            }
            .pure-img
            {
                display: block;
                height: auto;
                max-width: 100%;
            }
            .pure-g
            {
                display: -ms-flexbox;
                display: -webkit-flex;
                font-family: FreeSans,Arimo,"Droid Sans",Helvetica,Arial,sans-serif;
                letter-spacing: -.31em;
                letter-spacing: normal;
                ms-flex-flow: row wrap;
                text-rendering: optimizespeed;
                webkit-flex-flow: row wrap;
                word-spacing: -.43em;
            }
            .opera-only :-o-prefocus,.pure-g
            {
                word-spacing: -.43em;
            }
            .pure-u
            {
                display: inline;
                display: inline-block;
                letter-spacing: normal;
                text-rendering: auto;
                vertical-align: top;
                word-spacing: normal;
                zoom: 1;
            }
            .pure-g [class *="pure-u"]
            {
                font-family: sans-serif;
            }
            .pure-u-1,.pure-u-1-1,.pure-u-1-2,.pure-u-1-3,.pure-u-2-3,.pure-u-1-4,.pure-u-3-4,.pure-u-1-5,.pure-u-2-5,.pure-u-3-5,.pure-u-4-5,.pure-u-5-5,.pure-u-1-6,.pure-u-5-6,.pure-u-1-8,.pure-u-3-8,.pure-u-5-8,.pure-u-7-8,.pure-u-1-12,.pure-u-5-12,.pure-u-7-12,.pure-u-11-12,.pure-u-1-24,.pure-u-2-24,.pure-u-3-24,.pure-u-4-24,.pure-u-5-24,.pure-u-6-24,.pure-u-7-24,.pure-u-8-24,.pure-u-9-24,.pure-u-10-24,.pure-u-11-24,.pure-u-12-24,.pure-u-13-24,.pure-u-14-24,.pure-u-15-24,.pure-u-16-24,.pure-u-17-24,.pure-u-18-24,.pure-u-19-24,.pure-u-20-24,.pure-u-21-24,.pure-u-22-24,.pure-u-23-24,.pure-u-24-24
            {
                display: inline;
                display: inline-block;
                letter-spacing: normal;
                text-rendering: auto;
                vertical-align: top;
                word-spacing: normal;
                zoom: 1;
            }
            .pure-u-1-24
            {
                width: 4.1357%;
                width: 4.1667%;
            }
            .pure-u-1-12,.pure-u-2-24
            {
                width: 8.3023%;
                width: 8.3333%;
            }
            .pure-u-1-8,.pure-u-3-24
            {
                width: 12.469%;
                width: 12.5%;
            }
            .pure-u-1-6,.pure-u-4-24
            {
                width: 16.6357%;
                width: 16.6667%;
            }
            .pure-u-1-5
            {
                width: 19.969%;
                width: 20%;
            }
            .pure-u-5-24
            {
                width: 20.8023%;
                width: 20.8333%;
            }
            .pure-u-1-4,.pure-u-6-24
            {
                width: 24.969%;
                width: 25%;
            }
            .pure-u-7-24
            {
                width: 29.1357%;
                width: 29.1667%;
            }
            .pure-u-1-3,.pure-u-8-24
            {
                width: 33.3023%;
                width: 33.3333%;
            }
            .pure-u-3-8,.pure-u-9-24
            {
                width: 37.469%;
                width: 37.5%;
            }
            .pure-u-2-5
            {
                width: 39.969%;
                width: 40%;
            }
            .pure-u-5-12,.pure-u-10-24
            {
                width: 41.6357%;
                width: 41.6667%;
            }
            .pure-u-11-24
            {
                width: 45.8023%;
                width: 45.8333%;
            }
            .pure-u-1-2,.pure-u-12-24
            {
                width: 49.969%;
                width: 50%;
            }
            .pure-u-13-24
            {
                width: 54.1357%;
                width: 54.1667%;
            }
            .pure-u-7-12,.pure-u-14-24
            {
                width: 58.3023%;
                width: 58.3333%;
            }
            .pure-u-3-5
            {
                width: 59.969%;
                width: 60%;
            }
            .pure-u-5-8,.pure-u-15-24
            {
                width: 62.469%;
                width: 62.5%;
            }
            .pure-u-2-3,.pure-u-16-24
            {
                width: 66.6357%;
                width: 66.6667%;
            }
            .pure-u-17-24
            {
                width: 70.8023%;
                width: 70.8333%;
            }
            .pure-u-3-4,.pure-u-18-24
            {
                width: 74.969%;
                width: 75%;
            }
            .pure-u-19-24
            {
                width: 79.1357%;
                width: 79.1667%;
            }
            .pure-u-4-5
            {
                width: 79.969%;
                width: 80%;
            }
            .pure-u-5-6,.pure-u-20-24
            {
                width: 83.3023%;
                width: 83.3333%;
            }
            .pure-u-7-8,.pure-u-21-24
            {
                width: 87.469%;
                width: 87.5%;
            }
            .pure-u-11-12,.pure-u-22-24
            {
                width: 91.6357%;
                width: 91.6667%;
            }
            .pure-u-23-24
            {
                width: 95.8023%;
                width: 95.8333%;
            }
            .pure-u-1,.pure-u-1-1,.pure-u-5-5,.pure-u-24-24
            {
                width: 100%;
            }
            .pure-table
            {
                border: 1px solid #cbcbcb;
                border-collapse: collapse;
                border-spacing: 0;
                empty-cells: show;
            }
            .pure-table caption
            {
                color: #000;
                font: italic 85%/1 arial,sans-serif;
                padding: 1em 0;
                text-align: center;
            }
            .pure-table td,.pure-table th
            {
                border-left: 1px solid #cbcbcb;
                border-width: 0 0 0 1px;
                font-size: inherit;
                margin: 0;
                overflow: visible;
                padding: .5em 1em;
            }
            .pure-table td:first-child,.pure-table th:first-child
            {
                border-left-width: 0;
            }
            .pure-table thead
            {
                background: #e0e0e0;
                color: #000;
                text-align: left;
                vertical-align: bottom;
            }
            .pure-table td
            {
                background-color: transparent;
            }
            .pure-table-odd td
            {
                background-color: #f2f2f2;
            }
            .pure-table-striped tr:nth-child(2n-1) td
            {
                background-color: #f2f2f2;
            }
            .pure-table-bordered td
            {
                border-bottom: 1px solid #cbcbcb;
            }
            .pure-table-bordered tbody>tr:last-child td,.pure-table-horizontal tbody>tr:last-child td
            {
                border-bottom-width: 0;
            }
            .pure-table-horizontal td,.pure-table-horizontal th
            {
                border-bottom: 1px solid #cbcbcb;
                border-width: 0 0 1px;
            }
            .pure-table-horizontal tbody>tr:last-child td
            {
                border-bottom-width: 0;
            }
        </style>
    </head>
    <body>
        <h1>{bill_name}</h1>
        <hr>
        <div class="pure-g">
            <div class="pure-u-1-3">
                <h2>Details</h2>
                <table class="pure-table pure-table-bordered">
                    <thead>
                        <tr>
                            <th>Info</th>
                            <th>Value</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>Name</td>
                            <td>{name}</td>
                        </tr>
                        <tr>
                            <td>First Name</td>
                            <td>{firstName}</td>
                        </tr>
                        <tr>
                            <td>Email</td>
                            <td>{email}</td>
                        </tr>
                        <tr>
                            <td>Phone</td>
                            <td>{phone}</td>
                        </tr>
                        <tr>
                            <td>Street</td>
                            <td>{street}</td>
                        </tr>
                        <tr>
                            <td>Streetnumber</td>
                            <td>{streetNumber}</td>
                        </tr>
                        <tr>
                            <td>Zip-Code</td>
                            <td>{zipCode}</td>
                        </tr>
                        <tr>
                            <td>City</td>
                            <td>{city}</td>
                        </tr>
                        <tr>
                            <td>Country</td>
                            <td>{country}</td>
                        </tr>
                        <tr>
                            <td>Card Number</td>
                            <td>{cardNumber}</td>
                        </tr>
                        <tr>
                            <td>Expires</td>
                            <td>{expires}</td>
                        </tr>
                        <tr>
                            <td>Security Code</td>
                            <td>{securityCode}</td>
                        </tr>
                    </tbody>
                </table>
            </div>
            <div class="pure-u-2-3">
                <h2>All</h2>
                <table class="pure-table pure-table-bordered">
                    <tbody>
                        <tr>
                            <td>Date</td>
                            <td>{date}</td>
                        </tr>
                        <tr>
                            <td>Price</td>
                            <td><strong>{price}</strong></td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
        <h2>Shopping Cart</h2>
        <table class="pure-table pure-table-striped">
            <thead>
                <tr>
                    <th>Name</th>
                    <th>Type</th>
                    <th>Size</th>
                    <th>Logo</th>
                    <th>Amount</th>
                    <th>Price</th>
                </tr>
            </thead>
            <tbody>
                {shopping_items}
                <tr>
                    <td>{name}</td>
                    <td>{type}</td>
                    <td>{size}</td>
                    <td>{logo}</td>
                    <td>{amount}</td>
                    <td>{price}</td>
                </tr>
                {/shopping_items}
            </tbody>
        </table>
    </body>
</html>
