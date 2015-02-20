<?php
defined('BASEPATH') OR exit('No direct script access allowed');
?>

<div class="page-header">
	<h1>Admin</h1>
</div>

<div class="row">
	<div class="col-md-12">
		<div class="panel panel-default">
			<div class="panel-heading">
				<h3 class="panel-title">
					<span class="glyphicon glyphicon-th-list"></span> Members
				</h3>
			</div>
			<div class="panel-body">
				<table id="admin-table" class="table table-striped table-bordered" cellspacing="0" width="100%">
			        <thead>
			            <tr>
			                <th>ID</th>
			                <th>Name</th>
			                <th>Email</th>
			                <th>Admin</th>
			                <th>Last Login</th>
			                <th>IP Address</th>
			                <th>Browser</th>
			                <th>Platform</th>
			                <th>Tools</th>
			            </tr>
			        </thead>
			 
			        <tfoot>
			            <tr>
			                <th>ID</th>
			                <th>Name</th>
			                <th>Email</th>
			                <th>Admin</th>
			                <th>Last Login</th>
			                <th>IP Address</th>
			                <th>Browser</th>
			                <th>Platform</th>
			                <th>Tools</th>
			            </tr>
			        </tfoot>
			 
			        <tbody>
			        	{members}
			            <tr>
			            	<td>{id}</td>
			                <td>{name}</td>
			                <td>{email}</td>
			                <td><span class="label label-default">{admin}</span></td>
			                <td>{last_login}</td>
			                <td>{ip}</td>
			                <td>{browser}</td>
			                <td>{platform}</td>
			                <td>
			                	<a class="btn btn-primary btn-sm" href="<?php echo site_url('admin/profile/{id}'); ?>" data-toggle="tooltip" data-placement="top" title="View {name}'s Profile"><span class="glyphicon glyphicon-eye-open"></span>
		                        </a>
		                        <a class="btn btn-danger btn-sm" href="<?php echo site_url('admin/profile_delete/{id}'); ?>" data-toggle="tooltip" data-placement="top" title="Delete {name}'s Profile"><span class="glyphicon glyphicon-remove"></span>
		                        </a>
		                    </td>
			            </tr>
			            {/members}
			        </tbody>
			    </table>
			</div>
		</div>
	</div>
</div>

<div class="row">
	<div class="col-md-12">
	<div class="panel panel-default">
		<div class="panel-heading">
			<h3 class="panel-title">
				<span class="glyphicon glyphicon-bookmark"></span> Quick Shortcuts
			</h3>
		</div>
		<div class="panel-body">
			<div class="row">
				<div class="col-xs-12 col-md-12">
					<a href="<?php echo site_url('admin/register'); ?>" id="shortcut" class="btn btn-success btn-lg" role="button"><span class="glyphicon glyphicon-fire"></span> <br/>Make User</a>
				</div>
			</div>
		</div>
	</div>
</div>
</div>