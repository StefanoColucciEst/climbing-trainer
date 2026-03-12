import { Outlet } from 'react-router-dom'
import { BottomNav } from './BottomNav'

export function AppShell() {
  return (
    <div className="min-h-screen bg-bg">
      <main className="pb-24 max-w-lg mx-auto px-4">
        <Outlet />
      </main>
      <BottomNav />
    </div>
  )
}
