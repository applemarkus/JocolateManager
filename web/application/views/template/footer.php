<?php
defined('BASEPATH') OR exit('No direct script access allowed');
$page = uri_string();
?>
</div>
<br><br><br><br>
<footer class="footer hidden-xs" id="footer">
	<div class="container">
		<p class="text-muted">
        <div class="pull-right hidden-sm"><?php if($this->user->is_admin()) { echo "Page rendered in <strong>{elapsed_time}</strong> seconds. Memory Usage: <strong>{memory_usage}</strong>. "; } ?>Version <strong>1.0.0</strong></div>
        <strong><a href="http://petritzdesigns.at">&copy; jCorn Development</a></strong></p>
	</div>
</footer>
<a id="back-to-top" href="#" class="btn btn-primary btn-lg back-to-top" role="button" title="Click to return on the top page" data-toggle="tooltip" data-placement="top"><span class="glyphicon glyphicon-chevron-up"></span></a>

        <!-- Bootstrap core JavaScript
        ================================================== -->
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="<?php echo base_url(); ?>assets/js/jquery.min.js"></script>
        <script src="<?php echo base_url(); ?>assets/js/bootstrap.js"></script>
        <!-- Custom Javascript -->
        <script src="<?php echo base_url(); ?>assets/js/script.js"></script>


        <?php if($page == "member/bills" OR $page == "member/packages" OR $page == "admin/index" OR $page == "admin") { ?>
            <script src="<?php echo base_url(); ?>assets/js/jquery.datatables.js"></script>
            <script src="<?php echo base_url(); ?>assets/js/datatables.bootstrap.js"></script>

            <script>
                $("#bill-view").load(function() {
                    var link = $("#bill-view").get(0).contentWindow.location;
                    $("#bill-fullsize").attr("href", link);
                    $("#bill-refresh").attr("href", link);
                });
                $(document).ready(function() {
                    $('#bills-table').dataTable({
                        "aoColumnDefs": [
                          { 'bSortable': false, 'aTargets': [ 2 ] }
                       ]
                    });
                });

                $("#package-view").load(function() {
                    var link = $("#package-view").get(0).contentWindow.location;
                    $("#package-fullsize").attr("href", link);
                    $("#package-refresh").attr("href", link);
                });
                $(document).ready(function() {
                    $('#package-table').dataTable({
                        "aoColumnDefs": [
                          { 'bSortable': false, 'aTargets': [ 2 ] }
                       ]
                    });
                });

                $(document).ready(function() {
                    $('#admin-table').dataTable({
                        "aoColumnDefs": [
                          { 'bSortable': false, 'aTargets': [ 8 ] }
                       ]
                    });
                });
            </script>
        <?php } ?>

    </body>
    </html>